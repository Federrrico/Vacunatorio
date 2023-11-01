/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.CentroVacunacion;
import Entidades.Cita;
import Entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author federico.acenjo
 */
public class CitaData {

    private VacunaData vacunaD;
    private CiudadanoData ciudadanoD;

    private Connection con = null;

    public CitaData() {
        con = Conexion.getConexion();
        ciudadanoD = new CiudadanoData();
        vacunaD = new VacunaData();
    }

    public void guardarCita(Cita cita) {

        String sql = "INSERT INTO cita (ciudadano, fecha_cita, centro_vacunacion, codigo_refuerzo, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, cita.getCiudadano().getDni());
            ps.setTimestamp(2, Timestamp.valueOf(cita.getFecha_cita()));
            ps.setInt(3, cita.getCentro_vacunacion());
            //ps.setTimestamp(4, Timestamp.valueOf(cita.getFecha_colocacion()));
            //ps.setInt(4, cita.getVacuna().getNro_serie());
            ps.setInt(4, cita.getCodigo_refuerzo());
            ps.setInt(5, cita.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cita.setId_cita(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cita registrada con exito. Cita nro: " + cita.getId_cita());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cita existente");
        }
    }

    public Cita buscarCita(int id) {
        Cita cita = null;
        String sql = "SELECT * FROM cita WHERE id_cita = ?";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cita = new Cita();
                cita.setId_cita(id);
                cita.setCiudadano(ciudadanoD.buscarCiudadano(rs.getInt(2)));
                //LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.MIN)
                cita.setFecha_cita(rs.getTimestamp(3).toLocalDateTime());
                cita.setCentro_vacunacion(rs.getInt(4));
                if (rs.getTimestamp(5) != null) {
                    cita.setFecha_colocacion(rs.getTimestamp(5).toLocalDateTime());
                }
                if (rs.getInt(6) != 0) {
                    cita.setVacuna(vacunaD.buscarVacuna(rs.getInt(6)));
                }
                cita.setCodigo_refuerzo(rs.getInt(7));
                cita.setEstado(rs.getInt(8));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la cita");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cita ");
        }
        return cita;
    }

    public List<Cita> listarCitas() {
        List<Cita> citas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cita";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cita cita = new Cita();
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setCiudadano(ciudadanoD.buscarCiudadano(rs.getInt("ciudadano")));
                cita.setFecha_cita(rs.getTimestamp("fecha_cita").toLocalDateTime());
                cita.setCentro_vacunacion(rs.getInt("centro_vacunacion"));
                if (rs.getTimestamp("fecha_colocacion") != null) {
                    cita.setFecha_colocacion(rs.getTimestamp("fecha_colocacion").toLocalDateTime());
                }
                //System.out.println(rs.getInt("vacuna"));
                if (rs.getInt("vacuna") != 0) {
                    cita.setVacuna(vacunaD.buscarVacuna(rs.getInt("vacuna")));
                }

                cita.setCodigo_refuerzo(rs.getInt("codigo_refuerzo"));
                cita.setEstado(rs.getInt("estado"));
                citas.add(cita);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cita");
        }
        return citas;
    }

    public void modificarCita(Cita cita) {
        String sql = "UPDATE cita SET ciudadano = ?, fecha_cita = ?, centro_vacunacion = ?, "
                + "fecha_colocacion = ?, vacuna = ?, codigo_refuerzo = ?, estado = ? WHERE id_cita = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getCiudadano().getDni());
            ps.setTimestamp(2, Timestamp.valueOf(cita.getFecha_cita()));
            ps.setInt(3, cita.getCentro_vacunacion());
            if (cita.getFecha_colocacion() != null) {
                ps.setTimestamp(4, Timestamp.valueOf(cita.getFecha_colocacion()));
            } else {
                ps.setNull(4, 0);
            }
            if (cita.getVacuna() != null) {
                ps.setInt(5, cita.getVacuna().getNro_serie());
            } else {
                ps.setNull(5, 0);
            }

            ps.setInt(6, cita.getCodigo_refuerzo());
            ps.setInt(7, cita.getEstado());
            ps.setInt(8, cita.getId_cita());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cita modificada.");
            } else {
                JOptionPane.showMessageDialog(null, "La cita no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cita ");
        }
    }

    public void eliminarCita(int cita) {
        String sql = "UPDATE cita SET estado = 2 WHERE id_cita = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cita Cancelada.");
            } else {
                JOptionPane.showMessageDialog(null, "La cita no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cita ");
        }
    }

    public List<Cita> listarCitasCentroVac(CentroVacunacion cv) {
        List<Cita> citas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cita WHERE centro_vacunacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cv.getIdCV());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cita cita = new Cita();
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setCiudadano(ciudadanoD.buscarCiudadano(rs.getInt("ciudadano")));
                cita.setFecha_cita(rs.getTimestamp("fecha_cita").toLocalDateTime());
                cita.setCentro_vacunacion(rs.getInt("centro_vacunacion"));
                if (rs.getTimestamp("fecha_colocacion") != null) {
                    cita.setFecha_colocacion(rs.getTimestamp("fecha_colocacion").toLocalDateTime());
                }
                //System.out.println(rs.getInt("vacuna"));
                if (rs.getInt("vacuna") != 0) {
                    cita.setVacuna(vacunaD.buscarVacuna(rs.getInt("vacuna")));
                }

                cita.setCodigo_refuerzo(rs.getInt("codigo_refuerzo"));
                cita.setEstado(rs.getInt("estado"));
                citas.add(cita);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cita");
        }
        return citas;
    }

    public List<Cita> listarCitasCiudadano(Ciudadano cv) {
        List<Cita> citas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cita WHERE ciudadano = ? AND estado != 2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cv.getDni());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cita cita = new Cita();
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setCiudadano(ciudadanoD.buscarCiudadano(rs.getInt("ciudadano")));
                cita.setFecha_cita(rs.getTimestamp("fecha_cita").toLocalDateTime());
                cita.setCentro_vacunacion(rs.getInt("centro_vacunacion"));
                if (rs.getTimestamp("fecha_colocacion") != null) {
                    cita.setFecha_colocacion(rs.getTimestamp("fecha_colocacion").toLocalDateTime());
                }
                //System.out.println(rs.getInt("vacuna"));
                if (rs.getInt("vacuna") != 0) {
                    cita.setVacuna(vacunaD.buscarVacuna(rs.getInt("vacuna")));
                }

                cita.setCodigo_refuerzo(rs.getInt("codigo_refuerzo"));
                cita.setEstado(rs.getInt("estado"));
                citas.add(cita);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cita");
        }
        return citas;
    }

    public int cantCitasDisponibles() {
        int cantidad = 0;
        try {
            String sql = "SELECT COUNT(*) FROM cita WHERE estado = 0 ";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citas");
        }
        return cantidad;
    }

    public int cantVacunasAplicadasPorCentro( int ct, LocalDateTime fecha) {
        int cantidad = 0;
        try {
            String sql = "SELECT COUNT(*) FROM cita WHERE centro_vacunacion = ? AND fecha_colocacion = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1, ct);
            ps.setTimestamp(2, Timestamp.valueOf(fecha));
          
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cita");
        }
        return cantidad;
    }
}

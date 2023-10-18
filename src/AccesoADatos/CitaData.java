/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

        String sql = "INSERT INTO cita (ciudadano, fecha_cita, centro_vacunacion, fecha_colocacion, vacuna, codigo_refuerzo) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, cita.getCiudadano().getDni());
            ps.setTimestamp(2, Timestamp.valueOf(cita.getFecha_cita()));
            ps.setInt(3, cita.getCentro_vacunacion());
            ps.setTimestamp(4, Timestamp.valueOf(cita.getFecha_colocacion()));
            ps.setInt(5, cita.getVacuna().getNro_serie());
            ps.setInt(6, cita.getCodigo_refuerzo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
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
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cita=new Cita();
                cita.setId_cita(id);
                cita.setCiudadano(ciudadanoD.buscarCiudadano(rs.getInt(2)));
                //LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.MIN)
                cita.setFecha_cita(rs.getTimestamp(3).toLocalDateTime());
                cita.setCentro_vacunacion(rs.getInt(4));
                cita.setFecha_colocacion(rs.getTimestamp(5).toLocalDateTime());
                cita.setVacuna(vacunaD.buscarVacuna(rs.getInt(6)));
                cita.setCodigo_refuerzo(rs.getInt(7));
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
                cita.setFecha_colocacion(rs.getTimestamp("fecha_colocacion").toLocalDateTime());
                cita.setVacuna(vacunaD.buscarVacuna(rs.getInt("vacuna")));
                cita.setCodigo_refuerzo(rs.getInt("codigo_refuerzo"));
                citas.add(cita);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cita");
        }
        return citas;
    }
}

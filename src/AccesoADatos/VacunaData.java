/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Laboratorio;
import Entidades.Vacuna;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author federico.acenjo
 */
public class VacunaData {

    private LaboratorioData labD;
    private Connection con = null;

    public VacunaData() {
        con = Conexion.getConexion();
        labD = new LaboratorioData();
    }

    public void guardarVacuna(Vacuna vacuna) {
        String sql = "INSERT INTO vacuna (nro_serie, cuit, dosis, nombre_vacuna, antigeno, fecha_vencimiento, aplicada) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, vacuna.getNro_serie());
            ps.setLong(2, vacuna.getLaboratorio().getCuit());
            ps.setDouble(3, vacuna.getDosis());
            ps.setString(4, vacuna.getNombre_vacuna());
            ps.setString(5, vacuna.getAntigeno());
            ps.setTimestamp(6, Timestamp.valueOf(vacuna.getFecha_vencimiento().atStartOfDay()));
            ps.setBoolean(7, vacuna.getAplicada());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La vacuna ha sido cargada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Vacuna existente");
        } catch (NullPointerException ex) {
            System.out.println("Null pointer ex: " + ex);
        }
    }

    public Vacuna buscarVacuna(int nro_serie) {
        Vacuna vacuna = null;
        String sql = "SELECT * FROM vacuna WHERE nro_serie = ?";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, nro_serie);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna = new Vacuna();
                vacuna.setNro_serie(nro_serie);
                vacuna.setLaboratorio(labD.buscarLaboratorio(rs.getLong(2)));
                vacuna.setDosis(rs.getDouble(3));
                vacuna.setNombre_vacuna(rs.getString(4));
                vacuna.setAntigeno(rs.getString(5));
                vacuna.setFecha_vencimiento(rs.getTimestamp(6).toLocalDateTime().toLocalDate());
                vacuna.setAplicada(rs.getBoolean(7));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la vacuna");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla vacuna ");
        }
        return vacuna;
    }

    public List<Vacuna> listarVacunas() {
        List<Vacuna> vacunas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacuna";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vacuna vacuna = new Vacuna();
                vacuna.setNro_serie(rs.getInt("nro_serie"));
                vacuna.setLaboratorio(labD.buscarLaboratorio(rs.getLong("cuit")));
                vacuna.setDosis(rs.getDouble("dosis"));
                vacuna.setNombre_vacuna(rs.getString("nombre_vacuna"));
                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setFecha_vencimiento(rs.getTimestamp("fecha_vencimiento").toLocalDateTime().toLocalDate());
                vacuna.setAplicada(rs.getBoolean("aplicada"));
                vacunas.add(vacuna);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
        }
        return vacunas;
    }

    public List<Vacuna> listarVacunasDisponibles() {
        List<Vacuna> vacunas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacuna WHERE aplicada = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vacuna vacuna = new Vacuna();
                vacuna.setNro_serie(rs.getInt("nro_serie"));
                vacuna.setLaboratorio(labD.buscarLaboratorio(rs.getLong("cuit")));
                vacuna.setDosis(rs.getDouble("dosis"));
                vacuna.setNombre_vacuna(rs.getString("nombre_vacuna"));
                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setFecha_vencimiento(rs.getTimestamp("fecha_vencimiento").toLocalDateTime().toLocalDate());
                vacuna.setAplicada(rs.getBoolean("aplicada"));
                vacunas.add(vacuna);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
        }
        return vacunas;
    }

    public void modificarVacuna(Vacuna vacuna) {

        String sql = "UPDATE vacuna SET cuit = ?, dosis = ?, nombre_vacuna = ? ,antigeno = ?, fecha_vencimiento = ?, aplicada = ? WHERE nro_serie = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, vacuna.getLaboratorio().getCuit());
            ps.setDouble(2, vacuna.getDosis());
            ps.setString(3, vacuna.getNombre_vacuna());
            ps.setString(4, vacuna.getAntigeno());
            ps.setTimestamp(5, Timestamp.valueOf(vacuna.getFecha_vencimiento().atStartOfDay()));
            ps.setBoolean(6, vacuna.getAplicada());
            ps.setInt(7, vacuna.getNro_serie());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El vacuna no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna " + ex.getMessage());
        }
    }

    public void colocarVacuna(Vacuna vac) {

        String sql = "UPDATE vacuna SET aplicada = 1 WHERE nro_serie = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, vac.getNro_serie());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Aplicada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La vacuna no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna " + ex.getMessage());
        }
    }

    public List<Vacuna> listarVacunasXLaboratorio(Laboratorio lab) {
        List<Vacuna> vacunas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacuna WHERE cuit = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, lab.getCuit());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vacuna vacuna = new Vacuna();
                vacuna.setNro_serie(rs.getInt("nro_serie"));
                vacuna.setLaboratorio(labD.buscarLaboratorio(rs.getLong("cuit")));
                vacuna.setDosis(rs.getDouble("dosis"));
                vacuna.setNombre_vacuna(rs.getString("nombre_vacuna"));
                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setFecha_vencimiento(rs.getTimestamp("fecha_vencimiento").toLocalDateTime().toLocalDate());
                vacuna.setAplicada(rs.getBoolean("aplicada"));
                vacunas.add(vacuna);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
        }
        return vacunas;
    }

    public int cantVacunasDisponibles(int vacuna, Long lab) {
        int cantidad = 0;
        try {
            String sql = "SELECT COUNT(*) FROM vacuna WHERE aplicada = ? AND cuit = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, vacuna);
            ps.setLong(2, lab);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
        }
        return cantidad;
    }
    
    public int cantVacunasDisponibles() {
        int cantidad = 0;
        try {
            String sql = "SELECT COUNT(*) FROM vacuna WHERE aplicada = 0 ";
            PreparedStatement ps = con.prepareStatement(sql);
      
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
        }
        return cantidad;
    }
    
   
    
}

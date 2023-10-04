/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author federico.acenjo
 */
public class CiudadanoData {

    private Connection con = null;

    public CiudadanoData() {
        con = Conexion.getConexion();
    }

    public void guardarCiudadano(Ciudadano ciudadano) {

        String sql = "INSERT INTO ciudadano (dni, nombre_completo, correo_electronico, telefono, patologia, ambito_laboral) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombre_completo());
            ps.setString(3, ciudadano.getCorreo_electronico());
            ps.setInt(4, ciudadano.getTelefono());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbito_laboral());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ciudadano existente");
        }
    }
    
    public List<Ciudadano> listarCiudadanos() {
        List<Ciudadano> ciudadanos = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM ciudadano";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombre_completo(rs.getString("nombre_completo"));
                ciudadano.setCorreo_electronico(rs.getString("correo_electronico"));
                ciudadano.setTelefono(rs.getInt("telefono"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbito_laboral(rs.getString("ambito_laboral"));
                ciudadanos.add(ciudadano);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudadano");
        }
        return ciudadanos;
    }
    
    public void modificarCiudadano(Ciudadano ciudadano) {

        String sql = "UPDATE ciudadano SET nombre_completo = ?, correo_electronico = ?, telefono = ? ,patologia = ?, ambito_laboral = ? WHERE dni = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
           
            ps.setString(1, ciudadano.getNombre_completo());
            ps.setString(2, ciudadano.getCorreo_electronico());
            ps.setInt(3, ciudadano.getTelefono());
            ps.setString(4, ciudadano.getPatologia());
            ps.setString(5, ciudadano.getAmbito_laboral());
            ps.setInt(6, ciudadano.getDni());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El ciudadano no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudadano " + ex.getMessage());
        }
    }
}

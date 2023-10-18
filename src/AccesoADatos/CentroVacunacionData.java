/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.CentroVacunacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author federico.acenjo
 */
public class CentroVacunacionData {
    private Connection con = null;
    
    public CentroVacunacionData() {
        con = Conexion.getConexion();
    }
    
    public void guardarCentroVacunacion(CentroVacunacion centroVacunacion) {

        String sql = "INSERT INTO centroVacunacion (nombre, localidad, provincia, direccion, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, centroVacunacion.getNombre());
            ps.setString(2, centroVacunacion.getLocalidad());
            ps.setString(3, centroVacunacion.getProvincia());
            ps.setString(4, centroVacunacion.getDireccion());
            ps.setBoolean(5, true);
            int exito  = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (exito==1) {
               centroVacunacion.setIdCV(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "CentroVacunacion Agregado"); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CentroVacunacion existente " + ex);
        }
    }
    
    public CentroVacunacion buscarCentroVacunacion(int id) {
        CentroVacunacion centroVacunacion = null;
        String sql = "SELECT * FROM centroVacunacion WHERE id = ? AND estado = 1";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1,id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                centroVacunacion=new CentroVacunacion();
                centroVacunacion.setIdCV(1);
                centroVacunacion.setNombre(rs.getString(2));
                centroVacunacion.setLocalidad(rs.getString(3));
                centroVacunacion.setProvincia(rs.getString(4));
                centroVacunacion.setDireccion(rs.getString(5));
                centroVacunacion.setEstado(true);         
            } else {
                JOptionPane.showMessageDialog(null, "No existe el centro de vacunacion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CentroVacunacion ");
        }
        return centroVacunacion;
    }
    
    public List<CentroVacunacion> listarCentroVacunacions() {
        List<CentroVacunacion> centroVacunacions = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM centroVacunacion WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CentroVacunacion centroVacunacion = new CentroVacunacion();
                centroVacunacion.setIdCV(rs.getInt("id"));
                centroVacunacion.setNombre(rs.getString("nombre"));
                centroVacunacion.setLocalidad(rs.getString("localidad"));
                centroVacunacion.setProvincia(rs.getString("provincia"));
                centroVacunacion.setDireccion(rs.getString("direccion"));
                centroVacunacion.setEstado(true);
                centroVacunacions.add(centroVacunacion);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CentroVacunacion");
        }
        return centroVacunacions;
    }
    
    public List<CentroVacunacion> listarCentroVacunacionsPorProvincia(String provincia) {
        List<CentroVacunacion> centroVacunacions = new ArrayList<>();
        
        try {
            String sql = "SELECT localidad FROM centroVacunacion WHERE estado = 1 AND provincia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, provincia);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CentroVacunacion centroVacunacion = new CentroVacunacion();
                centroVacunacion.setIdCV(rs.getInt("id"));
                centroVacunacion.setNombre(rs.getString("nombre"));
                centroVacunacion.setLocalidad(rs.getString("localidad"));
                centroVacunacion.setProvincia(rs.getString("provincia"));
                centroVacunacion.setDireccion(rs.getString("direccion"));
                centroVacunacion.setEstado(true);
                centroVacunacions.add(centroVacunacion);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CentroVacunacion");
        }
        return centroVacunacions;
    }
    
    public void modificarCentroVacunacion(CentroVacunacion centroVacunacion) {

        String sql = "UPDATE centroVacunacion SET nombre = ?, localidad = ?, provincia = ?, direccion = ? WHERE id = ?";
        PreparedStatement ps = null;
        System.out.println(centroVacunacion.toString());
        try {
            ps = con.prepareStatement(sql);
           
            ps.setInt(5, centroVacunacion.getIdCV());
            ps.setString(1, centroVacunacion.getNombre());
            ps.setString(2, centroVacunacion.getLocalidad());
            ps.setString(3, centroVacunacion.getProvincia());
            ps.setString(4, centroVacunacion.getDireccion());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El centro de vacunacion no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CentroVacunacion ");
        }
    }
    
    public void eliminarCentroVacunacion(int id){
        String sql = "UPDATE centroVacunacion SET estado = 0 WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            int exito = ps.executeUpdate();  
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El centro de vacunacion no existe");
            }
            ps.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla centroVacunacion");
        }
    }
    
}

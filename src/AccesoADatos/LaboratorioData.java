/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Laboratorio;
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
public class LaboratorioData {
    
    private Connection con = null;
    
    public LaboratorioData() {
        con = Conexion.getConexion();
        
    }
    
    public void guardarLaboratorio(Laboratorio laboratorio) {

        String sql = "INSERT INTO laboratorio (cuit, nombre, pais_origen, direccion_fiscal) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, laboratorio.getCuit());
            ps.setString(2, laboratorio.getNombre());
            ps.setString(3, laboratorio.getPais_origen());
            ps.setString(4, laboratorio.getDireccion_fiscal());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Laboratorio existente " + ex);
        }
    }
    
    public Laboratorio buscarLaboratorio(int cuit) {
        Laboratorio laboratorio = null;
        String sql = "SELECT * FROM laboratorio WHERE cuit = ?";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1,cuit );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                laboratorio=new Laboratorio();
                laboratorio.setCuit(cuit);
                laboratorio.setNombre(rs.getString(2));
                laboratorio.setPais_origen(rs.getString(3));
                laboratorio.setDireccion_fiscal(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el laboratorio");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Laboratorio ");
        }
        return laboratorio;
    }
    
    public List<Laboratorio> listarLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM laboratorio";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setCuit(rs.getInt("cuit"));
                laboratorio.setNombre(rs.getString("nombre"));
                laboratorio.setPais_origen(rs.getString("pais_origen"));
                laboratorio.setDireccion_fiscal(rs.getString("direccion_fiscal"));
                laboratorios.add(laboratorio);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Laboratorio");
        }
        return laboratorios;
    }
    
    public void modificarLaboratorio(Laboratorio laboratorio) {

        String sql = "UPDATE laboratorio SET nombre = ?, pais_origen = ?, direccion_fiscal = ? WHERE cuit = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
           
            ps.setInt(1, laboratorio.getCuit());
            ps.setString(2, laboratorio.getNombre());
            ps.setString(3, laboratorio.getPais_origen());
            ps.setString(4, laboratorio.getDireccion_fiscal());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El laboratorio no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Laboratorio ");
        }
    }
}

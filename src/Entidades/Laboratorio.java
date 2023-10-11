/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author federico.acenjo
 */
public class Laboratorio {
    private Long cuit;
    private String nombre;
    private String pais_origen;
    private String direccion_fiscal;

    public Laboratorio() {
    }

    public Laboratorio(String nombre, String pais_origen, String direccion_fiscal) {
        this.nombre = nombre;
        this.pais_origen = pais_origen;
        this.direccion_fiscal = direccion_fiscal;
    }

    public Laboratorio(Long cuit, String nombre, String pais_origen, String direccion_fiscal) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.pais_origen = pais_origen;
        this.direccion_fiscal = direccion_fiscal;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public String getDireccion_fiscal() {
        return direccion_fiscal;
    }

    public void setDireccion_fiscal(String direccion_fiscal) {
        this.direccion_fiscal = direccion_fiscal;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "cuit=" + cuit + ", nombre=" + nombre + ", pais_origen=" + pais_origen + ", direccion_fiscal=" + direccion_fiscal + '}';
    }
    
    
}

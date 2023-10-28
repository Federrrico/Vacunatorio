/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author federico.acenjo
 */
public class Ciudadano {
    private int dni;
    private String nombre_completo;
    private String correo_electronico;
    private Long telefono;
    private String patologia = null;
    private String ambito_laboral;
    private String provincia;
    private String localidad;

    public Ciudadano() {
    }

    public Ciudadano(String nombre_completo, String correo_electronico, Long telefono, String ambito_laboral, String provincia, String localidad) {
        this.nombre_completo = nombre_completo;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.ambito_laboral = ambito_laboral;
        this.provincia = provincia;
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Ciudadano(int dni, String nombre_completo, String correo_electronico, Long telefono, String ambito_laboral, String provincia, String localidad) {
        this.dni = dni;
        this.nombre_completo = nombre_completo;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.ambito_laboral = ambito_laboral;
        this.provincia = provincia;
        this.localidad = localidad;
    }
    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbito_laboral() {
        return ambito_laboral;
    }

    public void setAmbito_laboral(String ambito_laboral) {
        this.ambito_laboral = ambito_laboral;
    }

    @Override
    public String toString() {
        return "Dni: " + dni + ", Nombre: " + nombre_completo;
    }

      
}

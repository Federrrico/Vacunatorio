/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author federico.acenjo
 */
public class Vacuna {
    private int nro_serie;
    private String nombre_vacuna;
    private double dosis;
    private String antigeno;
    private Date fecha_vencimiento;
    private Boolean aplicada;

    public Vacuna() {
    }

    public Vacuna(String nombre_vacuna, double dosis, String antigeno, Date fecha_vencimiento, Boolean aplicada) {
        this.nombre_vacuna = nombre_vacuna;
        this.dosis = dosis;
        this.antigeno = antigeno;
        this.fecha_vencimiento = fecha_vencimiento;
        this.aplicada = aplicada;
    }

    public Vacuna(int nro_serie, String nombre_vacuna, double dosis, String antigeno, Date fecha_vencimiento, Boolean aplicada) {
        this.nro_serie = nro_serie;
        this.nombre_vacuna = nombre_vacuna;
        this.dosis = dosis;
        this.antigeno = antigeno;
        this.fecha_vencimiento = fecha_vencimiento;
        this.aplicada = aplicada;
    }

    public int getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(int nro_serie) {
        this.nro_serie = nro_serie;
    }

    public String getNombre_vacuna() {
        return nombre_vacuna;
    }

    public void setNombre_vacuna(String nombre_vacuna) {
        this.nombre_vacuna = nombre_vacuna;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public String getAntigeno() {
        return antigeno;
    }

    public void setAntigeno(String antigeno) {
        this.antigeno = antigeno;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Boolean getAplicada() {
        return aplicada;
    }

    public void setAplicada(Boolean aplicada) {
        this.aplicada = aplicada;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "nro_serie=" + nro_serie + ", nombre_vacuna=" + nombre_vacuna + ", dosis=" + dosis + ", antigeno=" + antigeno + ", fecha_vencimiento=" + fecha_vencimiento + ", aplicada=" + aplicada + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author federico.acenjo
 */
public class Cita {
    private int id_cita;
    private Ciudadano ciudadano;
    private Date fecha_cita;
    private String centro_vacunacion;
    private Date fecha_colocacion;
    private Vacuna vacuna;
    private int codigo_refuerzo;

    public Cita() {
    }

    public Cita(Ciudadano ciudadano, Date fecha_cita, String centro_vacunacion, Date fecha_colocacion, Vacuna vacuna, int codigo_refuerzo) {
        this.ciudadano = ciudadano;
        this.fecha_cita = fecha_cita;
        this.centro_vacunacion = centro_vacunacion;
        this.fecha_colocacion = fecha_colocacion;
        this.vacuna = vacuna;
        this.codigo_refuerzo = codigo_refuerzo;
    }

    public Cita(int id_cita, Ciudadano ciudadano, Date fecha_cita, String centro_vacunacion, Date fecha_colocacion, Vacuna vacuna, int codigo_refuerzo) {
        this.id_cita = id_cita;
        this.ciudadano = ciudadano;
        this.fecha_cita = fecha_cita;
        this.centro_vacunacion = centro_vacunacion;
        this.fecha_colocacion = fecha_colocacion;
        this.vacuna = vacuna;
        this.codigo_refuerzo = codigo_refuerzo;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getCentro_vacunacion() {
        return centro_vacunacion;
    }

    public void setCentro_vacunacion(String centro_vacunacion) {
        this.centro_vacunacion = centro_vacunacion;
    }

    public Date getFecha_colocacion() {
        return fecha_colocacion;
    }

    public void setFecha_colocacion(Date fecha_colocacion) {
        this.fecha_colocacion = fecha_colocacion;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public int getCodigo_refuerzo() {
        return codigo_refuerzo;
    }

    public void setCodigo_refuerzo(int codigo_refuerzo) {
        this.codigo_refuerzo = codigo_refuerzo;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_cita=" + id_cita + ", ciudadano=" + ciudadano + ", fecha_cita=" + fecha_cita + ", centro_vacunacion=" + centro_vacunacion + ", fecha_colocacion=" + fecha_colocacion + ", vacuna=" + vacuna + ", codigo_refuerzo=" + codigo_refuerzo + '}';
    }


}

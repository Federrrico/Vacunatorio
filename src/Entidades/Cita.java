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
    private LocalDateTime fecha_cita;
    private int centro_vacunacion;
    private LocalDateTime fecha_colocacion;
    private Vacuna vacuna;
    private int codigo_refuerzo;
    private int estado;

    public Cita() {
    }

    public Cita(Ciudadano ciudadano, LocalDateTime fecha_cita, int centro_vacunacion, LocalDateTime fecha_colocacion, Vacuna vacuna, int codigo_refuerzo, int estado) {
        this.ciudadano = ciudadano;
        this.fecha_cita = fecha_cita;
        this.centro_vacunacion = centro_vacunacion;
        this.fecha_colocacion = fecha_colocacion;
        this.vacuna = vacuna;
        this.codigo_refuerzo = codigo_refuerzo;
        this.estado = estado;
    }

    public Cita(int id_cita, Ciudadano ciudadano, LocalDateTime fecha_cita, int centro_vacunacion, LocalDateTime fecha_colocacion, Vacuna vacuna, int codigo_refuerzo, int estado) {
        this.id_cita = id_cita;
        this.ciudadano = ciudadano;
        this.fecha_cita = fecha_cita;
        this.centro_vacunacion = centro_vacunacion;
        this.fecha_colocacion = fecha_colocacion;
        this.vacuna = vacuna;
        this.codigo_refuerzo = codigo_refuerzo;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public LocalDateTime getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDateTime fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public int getCentro_vacunacion() {
        return centro_vacunacion;
    }

    public void setCentro_vacunacion(int centro_vacunacion) {
        this.centro_vacunacion = centro_vacunacion;
    }

    public LocalDateTime getFecha_colocacion() {
        return fecha_colocacion;
    }

    public void setFecha_colocacion(LocalDateTime fecha_colocacion) {
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
        return "Cita{" + "id_cita=" + id_cita + ", ciudadano=" + ciudadano.getDni() + ", fecha_cita=" + fecha_cita + ", centro_vacunacion=" + centro_vacunacion + ", fecha_colocacion=" + fecha_colocacion + ", vacuna=" + vacuna.getNombre_vacuna() + ", codigo_refuerzo=" + codigo_refuerzo + '}';
    }


}

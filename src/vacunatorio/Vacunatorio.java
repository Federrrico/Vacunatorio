/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunatorio;

import AccesoADatos.*;
import Entidades.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author federico.acenjo
 */
public class Vacunatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CiudadanoData cd = new CiudadanoData();
        LaboratorioData ld = new LaboratorioData();
        VacunaData vd = new VacunaData();
        CitaData cid = new CitaData();
        CentroVacunacionData cvd = new CentroVacunacionData();
        CentroVacunacion cv = new CentroVacunacion(1, "Prueba", "PruebaLoc", "PruebaProv", "PruebaDir", true);
        Ciudadano fede = new Ciudadano(34155039, "Federico Acenjo", "federico@asdasd.com", 1155522255L, "casa", "Pilar", "Buenos Aires");
        Ciudadano fefe = new Ciudadano(34155037, "Federico Acenjo", "federico@asdasd.com", 1155522255L, "casa", "Pilar", "Buenos Aires");
        Laboratorio labP1 = new Laboratorio(32555666L, "Umbrella", "EEUU", "Calle falsa 123, Pueblo Fantasma");
        Vacuna vacP1 = new Vacuna(222555888, labP1, "UZ1", 0.3, "Z01", LocalDate.of(2024, 12, 10), true);
        Cita citP1 = new Cita (fede, LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.of(15, 00)), cv.getIdCV(), LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.of(15, 15)), vacP1, 1, 1);
        Cita citP2 = new Cita (fefe, LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.of(15, 00)),cv.getIdCV(),vacP1, 1, 0);
        
//        cd.guardarCiudadano(fede);
        //cd.guardarCiudadano(fefe);
//        cvd.guardarCentroVacunacion(cv);
//        ld.guardarLaboratorio(labP1);
//        vd.guardarVacuna(vacP1);
        cid.guardarCita(citP1);
        
        cid.guardarCita(citP2);
        cid.modificarCita(citP1);
        System.out.println("Traemos los Ciudadanos antes de la modificacion");
        for (Ciudadano ciudadano : cd.listarCiudadanos()) {
            System.out.println(ciudadano.toString());
        }
        
       // cd.modificarCiudadano(new Ciudadano(34155039, "Federico Acenjo", "fedeacen@lkjlkj.com", 1144422255L, "casa", "Pilar", "Buenos Aires"));
        
        System.out.println("Traemos los Ciudadanos despues de la modificacion");
        for (Ciudadano ciudadano : cd.listarCiudadanos()) {
            System.out.println(ciudadano.toString());
        }
        
        System.out.println("Traemos los Laboratorios");
        for (Laboratorio laboratorio : ld.listarLaboratorios()) {
            System.out.println(laboratorio.toString());
        }
        
        System.out.println("Traemos las Vacunas");
        for (Vacuna vacuna : vd.listarVacunas()) {
            System.out.println(vacuna.toString());
        }
        
        System.out.println("Traemos las Citas");
        for (Entidades.Cita cita : cid.listarCitas()) {
            System.out.println(cita.toString());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunatorio;

import AccesoADatos.*;
import Entidades.Ciudadano;

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
        Ciudadano fede = new Ciudadano(34155039, "Federico Acenjo", "federico@asdasd.com", 1155522255, "casa");
        
        cd.guardarCiudadano(fede);
        
        for (Ciudadano ciudadano : cd.listarCiudadanos()) {
            System.out.println(ciudadano.toString());
        }
        
        
    }
    
}

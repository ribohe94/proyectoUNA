/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.pkg1;

import controlador.Control;
import vista.VentanaTabla;

/**
 *
 * @author Bove
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control gestorPrincipal = new Control();
        VentanaTabla ventana = new VentanaTabla(gestorPrincipal);
        ventana.iniciar();
        
        System.out.println("Holis");
    }
    
}

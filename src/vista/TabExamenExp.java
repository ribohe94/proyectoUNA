/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Control;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Bove
 */
public class TabExamenExp extends JPanel {

    public TabExamenExp(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfiguracionInicial();
        ajustarComponentes();
    }

    private void ajustarConfiguracionInicial() {
        
    }

    private void ajustarComponentes(){
        ventExpedientes = new VentanaExpedientes(gestorPrincipal);
        ventExamenes = new VentanaExamen(gestorPrincipal);
        tabPaneles= new JTabbedPane();
        tabPaneles.add("Agregar Examenes", ventExamenes);
        tabPaneles.add("Ver Expedientes", ventExpedientes);
        
        this.setLayout(new BorderLayout());
        this.add(tabPaneles, BorderLayout.CENTER);
    }
    
    //Atributos
    private Control gestorPrincipal;
    
    private JTabbedPane tabPaneles;
    private VentanaExpedientes ventExpedientes;
    private VentanaExamen ventExamenes;
}


package vista;

import controlador.Control;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabExamenExp extends JPanel {

    public TabExamenExp(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarComponentes();
    }
    
    private void ajustarComponentes(){
        ventExpedientes = new VentanaExpedientes(gestorPrincipal);
        ventExamenes = new VentanaExamen(gestorPrincipal);
        tabPaneles= new JTabbedPane();        
        tabPaneles.add("Ver Expedientes", ventExpedientes);
        tabPaneles.add("Agregar Examenes", ventExamenes);
        
        this.setLayout(new BorderLayout());
        this.add(tabPaneles, BorderLayout.CENTER);
    }
    
    //Atributos
    private Control gestorPrincipal;
    
    private JTabbedPane tabPaneles;
    private VentanaExpedientes ventExpedientes;
    private VentanaExamen ventExamenes;
}

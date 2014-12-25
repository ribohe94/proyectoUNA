/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bove
 */
public class BarraEstado extends JPanel{
    public BarraEstado(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createEtchedBorder());
        lbMensaje = new JLabel("(No hay información disponible)");
        lbMensaje.setFont(TIPO_MENSAJE);
        add(lbMensaje);
    }
    
    
    public void mostrarMensaje(String mensaje){
        lbMensaje.setText(mensaje);
    }
    
    
    //Atributos
    private JLabel lbMensaje;
    private static final Font TIPO_MENSAJE = 
            new Font("SansSerif", Font.PLAIN, 12);
}

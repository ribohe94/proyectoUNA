
package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

    //Clase que define atributos y métodos de la barra de estado
public class BarraEstado extends JPanel{
    public BarraEstado(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(new Color(51, 51, 51));
        lbMensaje = new JLabel("(No hay información disponible)");
        lbMensaje.setFont(TIPO_MENSAJE);
        lbMensaje.setForeground(new Color(204, 204, 204));
        add(lbMensaje);
    }
    
    //Muestra un mensaje por la barra de estado
    public void mostrarMensaje(String mensaje){
        lbMensaje.setText(mensaje);
    }    
    
    //Atributos
    private JLabel lbMensaje;
    private static final Font TIPO_MENSAJE = 
            new Font("SansSerif", Font.PLAIN, 12);
}

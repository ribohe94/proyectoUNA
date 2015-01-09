
package vista;
    
import controlador.Control;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame{
    
    public VentanaPrincipal(){
        Control gestor = new Control();
        ventanaDoctores = new VentanaDoctores(gestor);
        ventanaPacientes = new VentanaPacientes(gestor);
        ventanaCitas = new VentanaCitas(gestor);
        ventanaExpedientes = new VentanaExpedientes(gestor);
        tabVentana = new JTabbedPane();
        
        ventanaDoctores.iniciar();
        ventanaPacientes.iniciar();
        ventanaCitas.iniciar();
        ventanaExpedientes.iniciar();
        
        ajustarConfiguracionInicial();
        ajustarComponentes(getContentPane());        
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                cerrar();
            }
        });
    }
    
    private void ajustarConfiguracionInicial(){
        setTitle("Aplicacion Hospital");
        setResizable(true);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void ajustarComponentes(Container c){        
        tabVentana.add("Doctores", ventanaDoctores);
        tabVentana.add("Pacientes", ventanaPacientes);
        tabVentana.add("Citas", ventanaCitas);        
        tabVentana.add("Expedientes", ventanaExpedientes);        
        
        c.add(tabVentana);
    }

    
    public void iniciar(){
        setVisible(true);
    }
    
    public void cerrar(){
        if(JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
           System.exit(0);
        }
    }      
    
    public void citas(){
        setVisible(false);
        ventanaCitas.iniciar();
    }          

    //ATRIBUTOS

    private JTabbedPane tabVentana;

    private VentanaDoctores ventanaDoctores;
    private VentanaCitas ventanaCitas;
    private VentanaPacientes ventanaPacientes;
    private VentanaExpedientes ventanaExpedientes;
}
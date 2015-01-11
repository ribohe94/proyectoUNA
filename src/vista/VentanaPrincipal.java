
package vista;
    
import controlador.Control;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

    //Clase que define, ajusta y muestra la ventana Principal
public class VentanaPrincipal extends JFrame{
    
    public VentanaPrincipal(){
        Control gestor = new Control();
        gestor.cargarDatosPacientes();
        gestor.cargarDatosDoctores();
        ventanaDoctores = new VentanaDoctores(gestor);
        ventanaPacientes = new VentanaPacientes(gestor);
        ventanaCitas = new VentanaCitas(gestor);
        ventanaExamen = new VentanaExamen(gestor);
        ventanaExpedientes = new VentanaExpedientes(gestor);
        tabExamenExp = new TabExamenExp(gestor);
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
    
    //Ajusta la configuración básica de la ventana
    private void ajustarConfiguracionInicial(){
        setTitle("Aplicacion Hospital");
        setResizable(true);
        setSize(800, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    //Ajusta los componentes de la ventana
    private void ajustarComponentes(Container c){        
        
        tabVentana.setBackground(new Color(150, 150, 150));
        
        tabVentana.add("Doctores", ventanaDoctores);
        tabVentana.add("Pacientes", ventanaPacientes);
        tabVentana.add("Citas", ventanaCitas);        
        tabVentana.add("Expedientes/Examenes", tabExamenExp);
        tabVentana.getSelectedComponent().setBackground(new Color(100, 100, 100));
        tabVentana.getSelectedComponent().setForeground(new Color(100, 100, 100));
        
        
        
        c.add(tabVentana);
    }
    
    //Inicia la ventana
    public void iniciar(){
        setVisible(true);
    }
    
    //Cierra la ventana
    public void cerrar(){
        if(JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
           System.exit(0);
        }
    }             

    //ATRIBUTOS

    private JTabbedPane tabVentana;

    private VentanaDoctores ventanaDoctores;
    private VentanaCitas ventanaCitas;
    private VentanaPacientes ventanaPacientes;
    private VentanaExamen ventanaExamen;
    private VentanaExpedientes ventanaExpedientes;
    private TabExamenExp tabExamenExp;
}

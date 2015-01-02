
package vista;
    
import controlador.Control;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame{
    
    public VentanaPrincipal(){
        Control gestor = new Control();
        ventanaDoctores = new VentanaDoctores(gestor);
        ventanaPacientes = new VentanaPacientes(gestor);
        ventanaCitas = new VentanaCitas(gestor);
        tabVentana = new JTabbedPane();
        
        tabVentana.add("Doctores", ventanaDoctores);
        tabVentana.add("Pacientes", ventanaPacientes);
        tabVentana.add("Citas", ventanaCitas);
        
        ajustarConfiguracionInicial();
        ajustarComponentes(getContentPane());
        ajustarEventos();
        //pack();    
        
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
        btnDoctores = new JButton("Administrar doctores");
        btnCitas = new JButton("Crear nueva cita");
        btnPacientes = new JButton("Consultar paciente");                
        
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));  
        panelBotones.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));
        panelBotones.add(btnDoctores);
        panelBotones.add(btnCitas);
        panelBotones.add(btnPacientes);                                
        
        lbPrincipal = new JLabel("MENU PRINCIPAL");        
        lbPrincipal.setFont(new Font(Font.SERIF, Font.BOLD, 45));
        
        panelEncabezado = new JPanel(new FlowLayout(FlowLayout.CENTER));                        
        panelEncabezado.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));        
        panelEncabezado.add(lbPrincipal);          
        
        lbSeleccione = new JLabel("Seleccione la opción deseada.");        
        lbSeleccione.setHorizontalAlignment(JLabel.CENTER);
        
        panelContenido = new JPanel(new BorderLayout());                        
        panelContenido.add(panelEncabezado, BorderLayout.NORTH);       
        panelContenido.add(panelBotones, BorderLayout.CENTER);
        panelContenido.add(lbSeleccione, BorderLayout.SOUTH);
        
        panelPrincipal = new JPanel();        
        panelPrincipal.add(panelContenido);
        
        c.add(tabVentana);
    }
    
    private void ajustarEventos(){
        btnDoctores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                doctores();
            }
        });
        
        btnCitas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                citas();
            }
        });
        
        btnPacientes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pacientes();
            }
        });
    }
    
    public void iniciar(){
        setVisible(true);
    }
    
    public void cerrar(){
        if(JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
           System.exit(0);
        }
    }     
    
    public void doctores(){
        setVisible(false);
        ventanaDoctores.iniciar();
    }  
        
    public void pacientes(){
        setVisible(false);
        ventanaPacientes.iniciar();
    }      
    
    public void citas(){
        setVisible(false);
        ventanaCitas.iniciar();
    }          

    //ATRIBUTOS
    //Paneles
    private JPanel panelContenido;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JPanel panelEncabezado;
    //Pestañas
    private JTabbedPane tabVentana;
    //Botones
    private JButton btnDoctores;
    private JButton btnPacientes;
    private JButton btnCitas;
    //Labels
    private JLabel lbSeleccione;    
    private JLabel lbPrincipal;
    
    private VentanaDoctores ventanaDoctores;
    private VentanaCitas ventanaCitas;
    private VentanaPacientes ventanaPacientes;
}
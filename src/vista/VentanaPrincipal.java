
package vista;
    
import controlador.Control;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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

public class VentanaPrincipal extends JFrame{
    
    public VentanaPrincipal(){
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
        
        Control gestor = new Control();
        ventanaDoctores = new VentanaDoctores(gestor);
        ventanaPacientes = new VentanaPacientes(gestor);
        ventanaCitas = new VentanaCitas(gestor);
    }
    
    private void ajustarConfiguracionInicial(){
        setTitle("Aplicacion Hospital");
        setResizable(false);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void ajustarComponentes(Container c){
        btnDoctores = new JButton("Consultar doctores");
        btnCitas = new JButton("Crear nueva cita");
        btnPacientes = new JButton("Consultar paciente");
        
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));        
        panelBotones.add(btnDoctores);
        panelBotones.add(btnCitas);
        panelBotones.add(btnPacientes);
        
        panelEncabezado = new JPanel(new FlowLayout(FlowLayout.CENTER));                
        
        lbEncabezado = new JLabel("Seleccione la opción deseada.");
        panelEncabezado.add(lbEncabezado);  
        
        panelContenido = new JPanel(new BorderLayout());
                
        panelContenido.add(panelEncabezado, BorderLayout.NORTH);       
        panelContenido.add(panelBotones, BorderLayout.SOUTH);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(120,0,0,0));
        panelPrincipal.add(panelContenido);
        
        c.add(panelPrincipal);
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
    private JPanel panelContenido;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JPanel panelEncabezado;    
    
    private JButton btnDoctores;
    private JButton btnPacientes;
    private JButton btnCitas;
    private JLabel lbEncabezado;    
    
    private VentanaDoctores ventanaDoctores;
    private VentanaCitas ventanaCitas;
    private VentanaPacientes ventanaPacientes;
}
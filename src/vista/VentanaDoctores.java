
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import controlador.Control;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.Doctor;
import modelo.Modelo;

public class VentanaDoctores extends JFrame implements Observer {

    public VentanaDoctores(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfiguracionInicial();
        ajustarComponentes(getContentPane());
        ajustarEventos();
    }

    private void ajustarConfiguracionInicial() {
        setTitle("Información de personas");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void ajustarComponentes(Container c) {        
        //GridBagConstraints gbc = new GridBagConstraints();
        estado = new BarraEstado();
        //inicializamos labels
        lbEncabezado = new JLabel("Use el Formulario para agregar doctores y la Tabla para editarlos o eliminarlos.");        
        lbNombre = new JLabel("Nombre: ");
        lbApellido = new JLabel("Apellido: ");
        lbId = new JLabel("Identificacion: ");
        lbEdad = new JLabel("Edad: ");
        //inicializamos TXT
        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);
        txtId = new JTextField(10);
        txtEdad = new JTextField(10);
        //inicializamos paneles
        panelEncabezado = new JPanel();
        panelTabla = new JPanel();        
        panelFormulario = new JPanel();
        panelContenidoFormulario = new JPanel();
        panelBtnAgregar = new JPanel();
        panelPrincipal = new JPanel();
        //inicializamos botones
        btnAgregar = new JButton("Agregar");
        btnVerExpediente = new JButton("Ver Expediente");
        btnEliminar = new JButton("Eliminar");
        //Inicializamos JRadioButton's
        rdbDisponible = new JRadioButton("Disponible");
        rdbNoDisponible = new JRadioButton("No Disponible");
        grupoRadioButton = new ButtonGroup();
        grupoRadioButton.add(rdbDisponible);
        grupoRadioButton.add(rdbNoDisponible);
        //Ajustamos panelEncabezado
        panelEncabezado.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEncabezado.setBorder(BorderFactory.createEmptyBorder(12, 12, 6, 12));
        panelEncabezado.add(lbEncabezado);        
        //Ajustamos Tabla
        tablaDatos = new JTable();
        JScrollPane scrollPaneTabla = new JScrollPane(tablaDatos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablaDatos.setFillsViewportHeight(true);
        configurarTabla(tablaDatos);
        //Ajustamos panelTabla        
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));
        panelTabla.add(scrollPaneTabla, BorderLayout.CENTER);
        panelTabla.add(btnEliminar, BorderLayout.SOUTH);        
        //Ajustamos panelContenidoFormulario
        panelContenidoFormulario.setLayout(new GridLayout(5, 2));
        panelContenidoFormulario.add(lbId);
        panelContenidoFormulario.add(txtId);
        panelContenidoFormulario.add(lbNombre);
        panelContenidoFormulario.add(txtNombre);
        panelContenidoFormulario.add(lbApellido);
        panelContenidoFormulario.add(txtApellido);
        panelContenidoFormulario.add(lbEdad);
        panelContenidoFormulario.add(txtEdad);
        panelContenidoFormulario.add(rdbDisponible);
        panelContenidoFormulario.add(rdbNoDisponible); 
        //Ajustamos panelBtnAgregar
        panelBtnAgregar.add(btnAgregar);
        //Ajustamos panelFormulario
        panelFormulario.setLayout(new BorderLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(60,10,8,0));
        panelFormulario.add(panelContenidoFormulario, BorderLayout.NORTH);        
        panelFormulario.add(panelBtnAgregar, BorderLayout.CENTER);
        
        
//        panelFormulario.setLayout(new GridBagLayout());
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        panelFormulario.add(lbId, gbc);
//        gbc.gridx = 1;
//        panelFormulario.add(txtId, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        panelFormulario.add(lbNombre, gbc);
//        gbc.gridx = 1;
//        panelFormulario.add(txtNombre, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        panelFormulario.add(lbApellido, gbc);
//        gbc.gridx = 1;
//        panelFormulario.add(txtApellido, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 2;                
//        panelFormulario.add(lbEdad, gbc);
//        gbc.gridx = 1;
//        panelFormulario.add(txtEdad, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        panelFormulario.add(btnAgregar, gbc);
//        gbc.gridx = 1;
//        panelFormulario.add(btnVerExpediente, gbc);
        
        
        //Ajustamos panelPrincipal
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.LINE_START);
        panelPrincipal.add(panelEncabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        
        c.add(panelPrincipal);
        c.add(estado, BorderLayout.PAGE_END);
    }

    public void configurarTabla(JTable tabla) {
        //En este llamado se asocia el modelo de la tabla
        // a la tabla (JTable)
        tabla.setModel(gestorPrincipal.modeloTabla());
        tabla.setAutoCreateRowSorter(false);
        tabla.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                gestorPrincipal.actualizar(String.format("Se actualizó el regsitro: %d",
                        e.getFirstRow() + 1));
            }
        });
    }
    
    private void ajustarEventos(){
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                boolean disponible = rdbDisponible.isSelected();

                Doctor nuevoDoctor = new Doctor(nombre, apellido, id, edad, disponible);
                                
                if(!gestorPrincipal.agregarDoctor(nuevoDoctor)){                    
                    JOptionPane.showMessageDialog(null, "Ya existe esta persona en el registro.", null, JOptionPane.ERROR_MESSAGE);        
                }                              
            }
        });
                
        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                gestorPrincipal.eliminarDoctor(tablaDatos.getSelectedRow());                        
            }
        });    
    }

    public void iniciar() {
        gestorPrincipal.registrar(this);
        gestorPrincipal.cargarDatos();
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }
    
    @Override
    public void update(Observable modelo, Object evento) {   
        if(evento instanceof String){
            estado.mostrarMensaje(((String)evento));
        }else{        
            tablaDatos.repaint();
            String idP = ((Doctor)evento).getId();
            String nombreP = ((Doctor)evento).getNombre();
            String apellidoP = ((Doctor)evento).getApellido();
        
            if(((Modelo)modelo).buscarDoctor(idP)){
                estado.mostrarMensaje(String.format("Se agregó al doctor: %s, %s %s", idP, nombreP, apellidoP));
            }else{
                estado.mostrarMensaje(String.format("Se eliminó al doctor: %s, %s %s", idP, nombreP, apellidoP));
            }                   
        }
    }


    //Atributo
    //Control
    private Control gestorPrincipal;
    //BarraEstado
    private BarraEstado estado;
    //JTable
    private JTable tablaDatos;
    //JPanel
    private JPanel panelPrincipal;
    private JPanel panelEncabezado;
    private JPanel panelTabla;    
    private JPanel panelFormulario;
    private JPanel panelContenidoFormulario;
    private JPanel panelBtnAgregar;
    //JLabel
    private JLabel lbEncabezado;    
    private JLabel lbNombre;
    private JLabel lbApellido;
    private JLabel lbId;
    private JLabel lbEdad;
    //TXT
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtId;
    private JTextField txtEdad;
    //Botones
    private JButton btnAgregar;
    private JButton btnVerExpediente;    
    private JButton btnEliminar;
    //RadioButton
    private JRadioButton rdbDisponible;
    private JRadioButton rdbNoDisponible;
    private ButtonGroup grupoRadioButton;
}
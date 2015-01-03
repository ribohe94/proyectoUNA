
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import controlador.Control;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.Modelo;
import modelo.Paciente;

public class VentanaPacientes extends JPanel implements Observer {
    public VentanaPacientes(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfiguracionInicial();
        ajustarComponentes();
        ajustarEventos();        
        estado.mostrarMensaje("Programa iniciado ...");
    }

    private void ajustarConfiguracionInicial() {
        setSize(800, 400);
    }
    
    GridBagConstraints gbc = new GridBagConstraints();
    private void ajustarComponentes() {                
        estado = new BarraEstado();
        //Inicializamos labels
        lbEncabezado = new JLabel("Use el Formulario para agregar pacientes y la Tabla para editarlos o eliminarlos.");        
        lbNombre = new JLabel("Nombre: ");
        lbApellidos = new JLabel("Apellidos: ");
        lbCedula = new JLabel("Identificacion: ");
        lbEdad = new JLabel("Edad: ");
        lbPeso = new JLabel("Peso: ");
        //Ajustamos Labels
        lbEncabezado.setForeground(new Color(204, 204, 204));
        lbNombre.setForeground(new Color(204, 204, 204));
        lbApellidos.setForeground(new Color(204, 204, 204));
        lbCedula.setForeground(new Color(204, 204, 204));
        lbEdad.setForeground(new Color(204, 204, 204));
        lbPeso.setForeground(new Color(204, 204, 204));
        //inicializamos TXT
        txtNombre = new JTextField(10);
        txtApellidos = new JTextField(10);
        txtCedula = new JTextField(10);
        txtEdad = new JTextField(10);
        txtPeso = new JTextField(10);
        //inicializamos paneles
        panelEncabezado = new JPanel();
        panelTabla = new JPanel();        
        panelFormulario = new JPanel();
        panelContenidoFormulario = new JPanel();
        panelBtnAgregar = new JPanel();
        panelPrincipal = new JPanel();
        //inicializamos botones
        btnAgregar = new JButton("Agregar");        
        btnEliminar = new JButton("Eliminar");        
        //Ajustamos panelEncabezado
        panelEncabezado.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEncabezado.setBackground(new Color(51, 51, 51));
        panelEncabezado.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        panelEncabezado.add(lbEncabezado);      
        //Ajustamos Tabla
        tablaDatos = new JTable();
        tablaDatos.setForeground(new Color(204, 204, 204));
        tablaDatos.setBackground(new Color(70, 70, 70));
        tablaDatos.setGridColor(new Color(102, 102, 102));
        tablaDatos.getTableHeader().setBackground(new Color(51, 51, 51));
        tablaDatos.getTableHeader().setForeground(new Color(204, 204, 204));
        JScrollPane scrollPaneTabla = new JScrollPane(tablaDatos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablaDatos.setFillsViewportHeight(true);
        configurarTabla(tablaDatos);
        //Ajustamos panelTabla        
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(new Color(102, 102, 102));
        panelTabla.setBorder(new CompoundBorder(new EmptyBorder(0, 10, 0, 10), BorderFactory.createTitledBorder("Estado Doctores")));
        panelTabla.add(scrollPaneTabla, BorderLayout.CENTER);
        panelTabla.add(btnEliminar, BorderLayout.SOUTH);        
        //Ajustamos panelContenidoFormulario
        panelContenidoFormulario.setLayout(new GridBagLayout());
        panelContenidoFormulario.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Formulario"), new EmptyBorder(0, 20, 0, 20)));
        panelContenidoFormulario.setBackground(new Color(102, 102, 102));
        
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelContenidoFormulario.add(lbCedula, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtCedula, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelContenidoFormulario.add(lbNombre, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelContenidoFormulario.add(lbApellidos, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtApellidos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelContenidoFormulario.add(lbEdad, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtEdad, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelContenidoFormulario.add(lbPeso, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtPeso, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelContenidoFormulario.add(btnAgregar, gbc);

        //Ajustamos panelFormulario
        panelFormulario.setLayout(new BorderLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(60,10,8,0));
        panelFormulario.add(panelContenidoFormulario, BorderLayout.NORTH);        
        panelFormulario.add(panelBtnAgregar, BorderLayout.CENTER);
        
        //Ajustamos panelPrincipal
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelContenidoFormulario, BorderLayout.LINE_START);
        panelPrincipal.add(panelEncabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        
        this.add(panelPrincipal);
        this.add(estado, BorderLayout.PAGE_END);
    }

    public void configurarTabla(JTable tabla) {
        //En este llamado se asocia el modelo de la tabla
        // a la tabla (JTable)
        tabla.setModel(gestorPrincipal.modeloTablaPacientes());
        tabla.setAutoCreateRowSorter(false);
        tabla.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                gestorPrincipal.actualizar(String.format("Se actualizó el registro: %d",
                        e.getFirstRow() + 1));
            }
        });
    }
    
    private void ajustarEventos(){
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int cedula = Integer.parseInt(txtCedula.getText());
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                float peso = Float.parseFloat(txtPeso.getText());

                Paciente nuevoPaciente = new Paciente(cedula, nombre, apellidos, edad, peso);
                                
                if(!gestorPrincipal.agregarPaciente(nuevoPaciente)){                    
                    JOptionPane.showMessageDialog(null, "Ya existe esta persona en el registro.", null, JOptionPane.ERROR_MESSAGE);        
                }
                tablaDatos.repaint();
                estado.repaint();
            }
        });
                
        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                gestorPrincipal.eliminarPaciente(tablaDatos.getSelectedRow());                        
            }
        });  
        tablaDatos.repaint();
    }

    public void iniciar() {
        gestorPrincipal.registrar(this);
        gestorPrincipal.cargarDatosPacientes();
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }
    
    @Override
    public void update(Observable modelo, Object evento) {   
        if(evento instanceof String){
            estado.mostrarMensaje(((String)evento));
        }else{        
            if(evento instanceof Paciente){
                tablaDatos.repaint();
                int cedulaP = ((Paciente)evento).getCedula();
                String nombreP = ((Paciente)evento).getNombre();
                String apellidosP = ((Paciente)evento).getApellidos();
                
                if(((Modelo)modelo).buscarPaciente(cedulaP)){
                    estado.mostrarMensaje(String.format("Se agregó al paciente: %s, %s %s", cedulaP, nombreP, apellidosP));
                }else{
                    estado.mostrarMensaje(String.format("Se eliminó al paciente: %s, %s %s", cedulaP, nombreP, apellidosP));
                }    
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
    private JLabel lbApellidos;
    private JLabel lbCedula;
    private JLabel lbEdad;
    private JLabel lbPeso;
    //TXT
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtCedula;
    private JTextField txtEdad;
    private JTextField txtPeso;
    //Botones
    private JButton btnAgregar;     
    private JButton btnEliminar;
}
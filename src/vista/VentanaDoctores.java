
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import controlador.Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.Doctor;
import modelo.Modelo;

public class VentanaDoctores extends JPanel implements Observer {
    public VentanaDoctores(Control nuevoGestor) {
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
        lbEncabezado = new JLabel("Use el Formulario para agregar doctores y la Tabla para editarlos o eliminarlos.");        
        lbNombre = new JLabel("Nombre: ");
        lbApellido = new JLabel("Apellido: ");
        lbId = new JLabel("Identificacion: ");
        lbEdad = new JLabel("Edad: ");
        //Ajustamos Labels
        lbEncabezado.setForeground(new Color(204, 204, 204));
        lbNombre.setForeground(new Color(204, 204, 204));
        lbApellido.setForeground(new Color(204, 204, 204));
        lbId.setForeground(new Color(204, 204, 204));
        lbEdad.setForeground(new Color(204, 204, 204));
        //inicializamos TXT
        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);
        txtId = new JTextField(10);
        txtEdad = new JTextField(10);
        //inicializamos paneles
        panelEncabezado = new JPanel();
        panelTabla = new JPanel();                
        panelContenidoFormulario = new JPanel();        
        panelPrincipal = new JPanel();
        //inicializamos botones
        btnAgregar = new JButton("Agregar");        
        btnEliminar = new JButton("Eliminar");        
        //Ajustamos botones
        
        //Inicializamos JRadioButton's
        rdbDisponible = new JRadioButton("Disponible");        
        rdbDisponible.setBackground(new Color(102, 102, 102));
        rdbDisponible.setForeground(new Color(204, 204, 204));
        rdbNoDisponible = new JRadioButton("No Disponible");
        rdbNoDisponible.setBackground(new Color(102, 102, 102));
        rdbNoDisponible.setForeground(new Color(204, 204, 204));
        grupoRadioButton = new ButtonGroup();
        grupoRadioButton.add(rdbDisponible);
        grupoRadioButton.add(rdbNoDisponible);
        rdbDisponible.setEnabled(true);
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
        
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelContenidoFormulario.add(lbId, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelContenidoFormulario.add(lbNombre, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelContenidoFormulario.add(lbApellido, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtApellido, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelContenidoFormulario.add(lbEdad, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(txtEdad, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelContenidoFormulario.add(rdbDisponible, gbc);
        gbc.gridx = 1;
        panelContenidoFormulario.add(rdbNoDisponible, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelContenidoFormulario.add(btnAgregar, gbc);
        
        //Ajustamos panelPrincipal
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelContenidoFormulario, BorderLayout.LINE_START);
        panelPrincipal.add(panelEncabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(102, 102, 102));
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(panelPrincipal, gbc);
        gbc.gridy = 1;
        this.add(estado, gbc);
    }

    public void configurarTabla(JTable tabla) {
        //En este llamado se asocia el modelo de la tabla
        // a la tabla (JTable)
        tabla.setModel(gestorPrincipal.modeloTablaDoctores());
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
                String id, nombre, apellido;
                int edad;
                boolean disponible;
                try {
                    id = txtId.getText();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El numero de identificacion ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    nombre = txtNombre.getText();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    apellido = txtApellido.getText();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El apellido ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    edad = Integer.parseInt(txtEdad.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La edad ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    disponible = rdbDisponible.isSelected();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un estado de disponibilidad.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Doctor nuevoDoctor = new Doctor(nombre, apellido, id, edad, disponible);
                                
                if(!gestorPrincipal.agregarDoctor(nuevoDoctor)){                    
                    JOptionPane.showMessageDialog(null, "Ya existe esta persona en el registro.", null, JOptionPane.ERROR_MESSAGE);        
                }
                tablaDatos.repaint();
                estado.repaint();
            }
        });
                
        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                gestorPrincipal.eliminarDoctor(tablaDatos.getSelectedRow());                        
            }
        });  
        tablaDatos.repaint();
    }

    public void iniciar() {
        gestorPrincipal.registrar(this);
        gestorPrincipal.cargarDatosDoctores();
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }
    
    @Override
    public void update(Observable modelo, Object evento) {   
        if(evento instanceof String){
            estado.mostrarMensaje(((String)evento));
        }else{        
            if (evento instanceof Doctor){
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
    private JPanel panelContenidoFormulario;    
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
    private JButton btnEliminar;
    //RadioButton
    private JRadioButton rdbDisponible;
    private JRadioButton rdbNoDisponible;
    private ButtonGroup grupoRadioButton;
}
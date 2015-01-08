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
        panelSubBtn = new JPanel();
        //panelFormulario = new JPanel();
        panelContenidoFormulario = new JPanel();
        panelBtnAgregar = new JPanel();
        panelBtnTabla = new JPanel();
        panelPrincipal = new JPanel();
        //inicializamos botones
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnExpediente = new JButton("Ver Expediente");
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
        //Ajustamos paneles de botones
        panelBtnAgregar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBtnAgregar.setBackground(new Color(102, 102, 102));
        panelBtnTabla.setLayout(new FlowLayout(FlowLayout.CENTER));
        //panelBtnTabla.setBackground(new Color(102, 102, 102));

        panelBtnAgregar.add(btnAgregar);
        panelBtnTabla.add(btnExpediente);
        //panelBtnTabla.add(panel1);

        //Ajustamos panelTabla        
        panelTabla.setLayout(new GridBagLayout());
        panelTabla.setBackground(new Color(102, 102, 102));
        panelTabla.setBorder(new CompoundBorder(new EmptyBorder(0, 10, 0, 10), BorderFactory.createTitledBorder("Estado Doctores")));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelTabla.add(scrollPaneTabla, gbc);

        panelSubBtn.setLayout(new GridBagLayout());
//        panelSubBtn.setBorder(BorderFactory.createLineBorder(Color.red));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSubBtn.add(btnExpediente, gbc);
        gbc.gridx = 1;
        panelSubBtn.add(btnEliminar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelTabla.add(panelSubBtn, gbc);
        //Ajustamos panelContenidoFormulario
        panelContenidoFormulario.setLayout(new GridBagLayout());
        panelContenidoFormulario.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Formulario"), new EmptyBorder(0, 20, 0, 20)));
        panelContenidoFormulario.setBackground(new Color(102, 102, 102));

        gbc.insets = new Insets(5, 0, 5, 0);
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
        panelContenidoFormulario.add(panelBtnAgregar, gbc);

        //Ajustamos panelPrincipal
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelContenidoFormulario, BorderLayout.LINE_START);
        panelPrincipal.add(panelEncabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);

        this.setLayout(new GridBagLayout());
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

    private void ajustarEventos() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula, edad;
                String nombre, apellidos;
                float peso;
                try {
                    cedula = Integer.parseInt(txtCedula.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El numero de identificacion ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    nombre = txtNombre.getText();
                    System.out.println(nombre);
                    if(nombre == ""){
                        JOptionPane.showMessageDialog(null, "El nombre ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    apellidos = txtApellidos.getText();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Los apellidos ingresados no son válidos.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    edad = Integer.parseInt(txtEdad.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La edad ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    peso = Float.parseFloat(txtPeso.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El peso ingresado no es válido.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Paciente nuevoPaciente = new Paciente(cedula, nombre, apellidos, edad, peso);

                if (!gestorPrincipal.agregarPaciente(nuevoPaciente)) {
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
        if (evento instanceof String) {
            estado.mostrarMensaje(((String) evento));
        } else {
            if (evento instanceof Paciente) {
                tablaDatos.repaint();
                int cedulaP = ((Paciente) evento).getCedula();
                String nombreP = ((Paciente) evento).getNombre();
                String apellidosP = ((Paciente) evento).getApellidos();

                if (((Modelo) modelo).buscarPaciente(cedulaP)) {
                    estado.mostrarMensaje(String.format("Se agregó al paciente: %s, %s %s", cedulaP, nombreP, apellidosP));
                } else {
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
    //private JPanel panelFormulario;
    private JPanel panelContenidoFormulario;
    private JPanel panelBtnAgregar;
    private JPanel panelBtnTabla;
    private JPanel panelSubBtn;
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
    private JButton btnExpediente;
}

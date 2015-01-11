package vista;

import java.awt.BorderLayout;
import java.util.Observer;
import controlador.Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

    //Clase que define, ajusta y muestra la ventana de expedientes
public class VentanaExpedientes extends JPanel implements Observer {

    public VentanaExpedientes(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfiguracionInicial();
        ajustarComponentes();
        ajustarEventos();
        estado.mostrarMensaje("Programa iniciado ...");
    }

    //Ajusta la configuración básica de la ventana
    private void ajustarConfiguracionInicial() {
        setSize(800, 400);
    }

    GridBagConstraints gbc = new GridBagConstraints();

    //Ajusta los componentes de la ventana
    private void ajustarComponentes() {
        estado = new BarraEstado();
        //Inicializamos paneles
        panelPrincipal = new JPanel(new BorderLayout());
        panelEncabezado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInfo = new JPanel(new GridBagLayout());
        panelExpediente = new JPanel(new GridBagLayout());
        //panelFormularioExamen = new JPanel(new GridBagLayout());
        //Inicializamos JLabel        
        lbEncabezado = new JLabel("Digite el número de cedula del paciente.");
        lbCedulaPaciente = new JLabel("Cedula del paciente : ");
        lbCedulaExpediente = new JLabel();
        lbListaExamenes = new JLabel();
        //Ajustamos labels
        lbEncabezado.setForeground(new Color(204, 204, 204));
        //Inicializamos TXT        
        txtCedulaPaciente = new JTextField(8);
        //Inicializamos Botones
        btnBuscarCedula = new JButton("Buscar Cedula");
        btnAgregarExamen = new JButton("Agregar Examen");
        //Inicializamos JCMB
        cmbCedula = new JComboBox();
        cedulas = new LinkedList<>();
        for (int i = 0; i < gestorPrincipal.numPacientes(); i++) {
            cedulas.add(gestorPrincipal.recuperarPaciente(i).getCedula());
            cmbCedula.addItem(gestorPrincipal.recuperarPaciente(i).getCedula());
        }
        //Ajustamos panelExpediente
        panelExpediente.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Listado de Exámenes"), new EmptyBorder(0, 20, 0, 20)));
        panelExpediente.setBackground(new Color(102, 102, 102));
        panelExpediente.add(lbListaExamenes);
        //Ajustamos panelFormularioExamen
        //panelFormularioExamen.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Formulario para Exámenes"), new EmptyBorder(0, 20, 0, 20)));
        //panelFormularioExamen.setBackground(new Color(102, 102, 102));

        //AGREGAR COMPONENTES
        gbc.insets = new Insets(5, 0, 5, 0);
        //Ajustamos panelEncabezado
        panelEncabezado.add(lbEncabezado);
        panelEncabezado.setBackground(new Color(51, 51, 51));
        panelEncabezado.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        //Ajustamos panelInfo             
        panelInfo.setBackground(new Color(102, 102, 102));
        panelInfo.setPreferredSize(new Dimension(750, 500));
        panelInfo.setBorder(new CompoundBorder(new EmptyBorder(100, 100, 100, 100), BorderFactory.createTitledBorder("Consulta de expedientes")));
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.gridwidth = 2;
        panelInfo.add(lbCedulaPaciente, gbc);
        gbc.gridx = 1;
        panelInfo.add(cmbCedula, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelInfo.add(btnBuscarCedula, gbc);
        //Ajustamos panelPrincipal
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);
        panelPrincipal.add(estado, BorderLayout.SOUTH);

        //Ajustamos Tgis
        this.setLayout(new BorderLayout());
        setBackground(new Color(102, 102, 102));
        add(panelPrincipal, BorderLayout.CENTER);
    }

    //Ajusta los eventos de la ventana
    private void ajustarEventos() {
        btnBuscarCedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula;
                try {
                    cedula = cedulas.get(cmbCedula.getSelectedIndex());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "La Cédula ingresada no es válida.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (gestorPrincipal.buscarPaciente(cedula)) {
                    lbCedulaExpediente.setText("Cédula del Paciente : " + cedula);                                   
                    lbListaExamenes.setText(String.format("Listado de Exámenes del Paciente. %n%s", gestorPrincipal.getExamenes(cedula)));                    
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    panelExpediente.add(lbCedulaExpediente, gbc);
                    gbc.gridy = 1;
                    gbc.gridwidth = 3;
//                    gbc.gridheight = 9;
//                    gbc.fill = GridBagConstraints.VERTICAL;                    
                    panelExpediente.add(lbListaExamenes, gbc);

                    //Remueve el panel original de la ventana y coloca 2 más para mostrar la información
                    //de los examenes y el formulario para agregar examenes
                    panelPrincipal.remove(panelInfo);
                    panelPrincipal.add(panelExpediente, BorderLayout.CENTER);
                    //panelPrincipal.add(panelFormularioExamen, BorderLayout.EAST);

                } else {
                    JOptionPane.showMessageDialog(null, "No existe un expediente con éste número de cédula.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
        });

        btnAgregarExamen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AGREGA EL EXAMEN

                //Regresa los paneles originales a la ventana
                //panelPrincipal.remove(panelFormularioExamen);
                panelPrincipal.remove(panelExpediente);
                panelPrincipal.add(panelInfo, BorderLayout.CENTER);
            }

        });

    }

    //Inicia la ventana
    public void iniciar() {
        gestorPrincipal.registrar(this);
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }

    //Actualiza la información proveniente del modelo
    @Override
    public void update(Observable modelo, Object evento) {
    }

    //Atributos
    //Control
    private Control gestorPrincipal;
    //BarraEstado
    private BarraEstado estado;
    //JPanel
    private JPanel panelPrincipal;
    private JPanel panelEncabezado;
    private JPanel panelInfo;
    private JPanel panelExpediente;
    //private JPanel panelFormularioExamen;
    /*JTabbedPane*/
    private JTabbedPane tabPaneles;
    //JLabel
    private JLabel lbEncabezado;
    private JLabel lbCedulaPaciente;
    private JLabel lbCedulaExpediente;
    private JLabel lbListaExamenes;
    //TXT
    private JTextField txtCedulaPaciente;
    //Botones
    private JButton btnBuscarCedula;
    private JButton btnAgregarExamen;
    //CMB
    private JComboBox cmbCedula;
    private List<Integer> cedulas;
}

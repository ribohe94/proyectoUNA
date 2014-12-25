/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Bove
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import controlador.Control;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class VentanaTabla extends JFrame implements Observer {

    public VentanaTabla(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfiguracionInicial();
        ajustarComponentes(getContentPane());
    }

    private void ajustarConfiguracionInicial() {
        setTitle("Información de personas");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    GridBagConstraints gbc = new GridBagConstraints();
    private void ajustarComponentes(Container c) {
        //inicializamos barraEstado
        estado = new BarraEstado();
        //inicializamos labels
        lbSubtitulo = new JLabel("Haga doble-clic para editar los valores");
        lbFormulario = new JLabel("Formulario");
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
        panelPrincipal = new JPanel();
        panelFormulario = new JPanel();
        //inicializamos botones
        btnAgregar = new JButton("Agregar");
        btnVerExpediente = new JButton("Ver Expediente");
        //Ajustamos panelEncabezado
        panelEncabezado.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEncabezado.setBorder(BorderFactory.createEmptyBorder(12, 12, 6, 12));
        panelEncabezado.add(lbSubtitulo);
        //Ajustamos panelTabla
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));
        //Ajustamos Tabla
        tablaDatos = new JTable();
        JScrollPane scrollPaneTabla = new JScrollPane(tablaDatos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablaDatos.setFillsViewportHeight(true);
        configurarTabla(tablaDatos);
        //Ajustamos panelTabla
        panelTabla.add(scrollPaneTabla, BorderLayout.CENTER);
        //justamos panelPrincipal
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.LINE_START);
        panelPrincipal.add(panelEncabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        //Ajustamos panelFormulario
        panelFormulario.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(lbNombre, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lbApellido, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtApellido, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(lbId, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lbEdad, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtEdad, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelFormulario.add(btnAgregar, gbc);
        gbc.gridx = 1;
        panelFormulario.add(btnVerExpediente, gbc);
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

    public void iniciar() {
        gestorPrincipal.registrar(this);
        gestorPrincipal.cargarDatos();
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }

    @Override
    public void update(Observable modelo, Object evento) {
        estado.mostrarMensaje(String.format("Actualización (%s): %s", modelo, evento));
    }

    //Atributo
    //Control
    private Control gestorPrincipal;
    //BarraEstado
    private BarraEstado estado;
    //JTable
    private JTable tablaDatos;
    //Jpanel
    private JPanel panelPrincipal;
    private JPanel panelEncabezado;
    private JPanel panelTabla;
    private JPanel panelFormulario;
    //JLabel
    private JLabel lbSubtitulo;
    private JLabel lbFormulario;
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

}

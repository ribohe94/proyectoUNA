
package vista;

import controlador.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import modelo.Expediente;

public class VentanaExamen extends JPanel implements Observer{

    public VentanaExamen(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        gestorPrincipal.registrar(this);
        ajustarConfigInic();
        ajustarComponentes();
        ajustarEventos();
        estado.mostrarMensaje("Programa iniciado ...");
    }

    //Ajusta la configuración básica de la ventana
    private void ajustarConfigInic() {
        setSize(800, 400);
    }

    //Ajusta los componentes de la ventana
    private void ajustarComponentes() {
        estado = new BarraEstado();
        //inicializamos Colores
        clrLetraLabels = new Color(204, 204, 204);
        //inicializamos Paneles
        panelSangre = new JPanel(new GridBagLayout());
        panelPrincipalSangre = new JPanel(new BorderLayout());
        panelEncabezado = new JPanel();
        tabPanel = new JTabbedPane();
        //inicializamos TXTFields
        txtHematocrito = new JTextField(10);
        txtHemoglobina = new JTextField(10);
        txtLeucocitos = new JTextField(10);
        txtSegmentados = new JTextField(10);
        txtLinfocitos = new JTextField(10);
        txtECG = new JTextField(10);
        txtInterPR = new JTextField(10);
        txtAlteracionesST = new JTextField(10);
        txtFrecuencia = new JTextField(10);
        txtEjeCorazon = new JTextField(10);
        txtFracturas = new JTextField(10);
        txtInfarto = new JTextField(10);
        txtCalcificacion = new JTextField(10);
        txtHemorragia = new JTextField(10);
        txtTrauma = new JTextField(10);
        txtProtuberancia = new JTextField(10);
        txtAneurisma = new JTextField(10);
        txtEstenosis = new JTextField(10);
        txtHuevo = new JTextField(10);
        txtLeche = new JTextField(10);
        txtNueces = new JTextField(10);
        txtMariscos = new JTextField(10);
        //inicializamos Labels
        lbCedula = new JLabel("Cedula del paciente: ");

        lbSangre = new JLabel("SANGRE");
        lbElectroCardio = new JLabel("Electrocardiograma");
        lbTAC = new JLabel("TAC");
        lbMRA = new JLabel("MRA");
        lbAlergia = new JLabel("Alergias");

        lbHematocrito = new JLabel("Hematocrito: ");
        lbHemoglobina = new JLabel("Hemoglobina: ");
        lbLeucocitos = new JLabel("Leucocitos: ");
        lbSegmentados = new JLabel("Segmentados: ");
        lbLinfocitos = new JLabel("Linfocitos: ");
        lbEncabezado = new JLabel("Use el Formulario para agregar examenes a los expedientes.");

        lbECG = new JLabel("ECG: ");
        lbInterPR = new JLabel("Intervalo PR: ");
        lbAlteracionesST = new JLabel("Alteraciones SR: ");
        lbFrecuencia = new JLabel("Frecuencia Cardiaca: ");
        lbEjeCorazon = new JLabel("Eje del corazón: ");

        lbFracturas = new JLabel("Fracturas: ");
        lbInfarto = new JLabel("Infartos (Tejido): ");
        lbCalcificacion = new JLabel("Calcificacion: ");
        lbHemorragia = new JLabel("Hemorragias: ");
        lbTrauma = new JLabel("Traumas: ");

        lbProtuberancia = new JLabel("Protuberancia: ");
        lbAneurisma = new JLabel("Aneurisma: ");
        lbEstenosis = new JLabel("Estenosis: ");

        lbHuevo = new JLabel("Huevo: ");
        lbLeche = new JLabel("Leche: ");
        lbNueces = new JLabel("Nueces: ");
        lbMariscos = new JLabel("Mariscos: ");

        lbHematocrito.setForeground(clrLetraLabels);
        lbHemoglobina.setForeground(clrLetraLabels);
        lbLeucocitos.setForeground(clrLetraLabels);
        lbSegmentados.setForeground(clrLetraLabels);
        lbLinfocitos.setForeground(clrLetraLabels);

        lbECG.setForeground(clrLetraLabels);
        lbInterPR.setForeground(clrLetraLabels);
        lbAlteracionesST.setForeground(clrLetraLabels);
        lbFrecuencia.setForeground(clrLetraLabels);
        lbEjeCorazon.setForeground(clrLetraLabels);

        lbFracturas.setForeground(clrLetraLabels);
        lbInfarto.setForeground(clrLetraLabels);
        lbCalcificacion.setForeground(clrLetraLabels);
        lbHemorragia.setForeground(clrLetraLabels);
        lbTrauma.setForeground(clrLetraLabels);

        lbProtuberancia.setForeground(clrLetraLabels);
        lbAneurisma.setForeground(clrLetraLabels);
        lbEstenosis.setForeground(clrLetraLabels);

        lbHuevo.setForeground(clrLetraLabels);
        lbLeche.setForeground(clrLetraLabels);
        lbNueces.setForeground(clrLetraLabels);
        lbMariscos.setForeground(clrLetraLabels);

        lbEncabezado.setForeground(new Color(204, 204, 204));
        //inicializamos Botones
        btnAgregar = new JButton("Agregar");
        //Inicializamos JCMB
        cmbCedula = new JComboBox();
        cedulas = new LinkedList<>();
        for (int i = 0; i < gestorPrincipal.numPacientes(); i++) {
            cedulas.add(gestorPrincipal.recuperarPaciente(i).getCedula());
            cmbCedula.addItem(gestorPrincipal.recuperarPaciente(i).getCedula());
        }

        //Ajustamos panelEncabezado
        panelEncabezado.add(lbEncabezado);
        panelEncabezado.setBackground(new Color(51, 51, 51));
        panelEncabezado.setBorder(BorderFactory.createEtchedBorder());
        //Ajustamos panelSangre
        panelSangre.setBackground(new Color(102, 102, 102));
        panelSangre.setPreferredSize(new Dimension(750, 500));
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 5, 0);
        panelSangre.add(lbSangre, gbc);
        gbc.insets = new Insets(5, 5, 5, 0);
        gbc.gridx = 4;
        gbc.gridy = 1;
        panelSangre.add(cmbCedula, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        panelSangre.add(lbCedula, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelSangre.add(lbHematocrito, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHematocrito, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelSangre.add(lbHemoglobina, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHemoglobina, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelSangre.add(lbLeucocitos, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtLeucocitos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelSangre.add(lbSegmentados, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtSegmentados, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelSangre.add(lbLinfocitos, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtLinfocitos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panelSangre.add(lbElectroCardio, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelSangre.add(lbECG, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtECG, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelSangre.add(lbAlteracionesST, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtAlteracionesST, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        panelSangre.add(lbInterPR, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtInterPR, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelSangre.add(lbFrecuencia, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtFrecuencia, gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        panelSangre.add(lbEjeCorazon, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtEjeCorazon, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        panelSangre.add(lbTAC, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        panelSangre.add(lbFracturas, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtFracturas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 14;
        panelSangre.add(lbInfarto, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtInfarto, gbc);
        gbc.gridx = 0;
        gbc.gridy = 15;
        panelSangre.add(lbCalcificacion, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtCalcificacion, gbc);
        gbc.gridx = 0;
        gbc.gridy = 16;
        panelSangre.add(lbHemorragia, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHemorragia, gbc);
        gbc.gridx = 0;
        gbc.gridy = 17;
        panelSangre.add(lbTrauma, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtTrauma, gbc);

        gbc.gridx = 1;
        gbc.gridy = 18;
        panelSangre.add(lbMRA, gbc);
        gbc.gridx = 0;
        gbc.gridy = 19;
        panelSangre.add(lbProtuberancia, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtProtuberancia, gbc);
        gbc.gridx = 0;
        gbc.gridy = 20;
        panelSangre.add(lbAneurisma, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtAneurisma, gbc);
        gbc.gridx = 0;
        gbc.gridy = 21;
        panelSangre.add(lbEstenosis, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtEstenosis, gbc);

        gbc.gridx = 1;
        gbc.gridy = 22;
        panelSangre.add(lbAlergia, gbc);
        gbc.gridx = 0;
        gbc.gridy = 23;
        panelSangre.add(lbHuevo, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHuevo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 24;
        panelSangre.add(lbLeche, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtLeche, gbc);
        gbc.gridx = 0;
        gbc.gridy = 25;
        panelSangre.add(lbNueces, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtNueces, gbc);
        gbc.gridx = 0;
        gbc.gridy = 26;
        panelSangre.add(lbMariscos, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtMariscos, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 27;
        gbc.insets = new Insets(5, 0, 70, 0);
        panelSangre.add(btnAgregar, gbc);
        panelSangre.setPreferredSize(new Dimension(WIDTH, 900));
        panelSangre.setBorder(new CompoundBorder(new EmptyBorder(10, 50, 10, 50), BorderFactory.createTitledBorder("Formulario de Examenes")));
        JScrollPane scrollPaneTabla = new JScrollPane(panelSangre, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panelPrincipalSangre.setLayout(new BorderLayout());
        panelPrincipalSangre.setPreferredSize(new Dimension(WIDTH, 800));
        panelPrincipalSangre.setBackground(new Color(102, 102, 102));
        panelPrincipalSangre.add(panelEncabezado, BorderLayout.NORTH);
        panelPrincipalSangre.add(scrollPaneTabla, BorderLayout.CENTER);
        panelPrincipalSangre.add(estado, BorderLayout.SOUTH);

        //Ajustamos tabPanel
        tabPanel.add("Sangre", panelPrincipalSangre);

        //Ajustamos this
        this.setBackground(new Color(102, 102, 102));
        setLayout(new BorderLayout());
        this.add(panelPrincipalSangre, BorderLayout.CENTER);
    }

    //Ajusta los eventos de la ventana
    private void ajustarEventos() {
        btnAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula = cedulas.get(cmbCedula.getSelectedIndex());
                //Expediente expediente = new Expediente(cedulas.get(cmbCedula.getSelectedIndex()));
//                System.out.println(cedulas.get(cmbCedula.getSelectedIndex()) + lbHematocrito.getText());               
                
                //Examen Sangre                
                if(!txtHematocrito.getText().isEmpty() || !txtHemoglobina.getText().isEmpty() || !txtLeucocitos.getText().isEmpty() || !txtSegmentados.getText().isEmpty() || !txtLinfocitos.getText().isEmpty() ){
                    String examenSangre = String.format( "Examen de Sangre.\n" +
                            lbHematocrito.getText() + txtHematocrito.getText() + "%n" + 
                            lbHemoglobina.getText() + txtHemoglobina.getText() + "%n" +
                            lbLeucocitos.getText() + txtLeucocitos.getText() + "%n" +
                            lbSegmentados.getText() + txtSegmentados.getText() + "%n" +
                            lbLinfocitos.getText() + txtLinfocitos.getText() + "%n");
                    //Se agrega el examen
                    gestorPrincipal.addExamen(examenSangre, cedula);
                }                

                //Examen Electrocardiograma
                if(!txtECG.getText().isEmpty() || !txtInterPR.getText().isEmpty() || !txtAlteracionesST.getText().isEmpty() || !txtFrecuencia.getText().isEmpty() || !txtEjeCorazon.getText().isEmpty() ){
                    String examenElectrocardiograma = String.format( "Examen de Electrocardiograma.%n" +
                            lbECG.getText() + txtECG.getText() + "%n" + 
                            lbInterPR.getText() + txtInterPR.getText() + "%n" +
                            lbAlteracionesST.getText() + txtAlteracionesST.getText() + "%n" +
                            lbFrecuencia.getText() + txtFrecuencia.getText() + "%n" +
                            lbEjeCorazon.getText() + txtEjeCorazon.getText() + "%n");
                    //Se agrega el examen
                    gestorPrincipal.addExamen(examenElectrocardiograma, cedula);
                }

                //Examen TAC
                if(!txtFracturas.getText().isEmpty() || !txtInfarto.getText().isEmpty() || !txtCalcificacion.getText().isEmpty() || !txtHemorragia.getText().isEmpty() || !txtTrauma.getText().isEmpty() ){
                    String examenTAC = String.format( "Examen TAC.%n" +
                            lbFracturas.getText() + txtFracturas.getText() + "%n" + 
                            lbInfarto.getText() + txtInfarto.getText() + "%n" +
                            lbCalcificacion.getText() + txtCalcificacion.getText() + "%n" +
                            lbHemorragia.getText() + txtHemorragia.getText() + "%n" +
                            lbTrauma.getText() + txtTrauma.getText() + "%n");
                    //Se agrega el examen
                    gestorPrincipal.addExamen(examenTAC, cedula);
                }

                //MRA
                if(!txtProtuberancia.getText().isEmpty() || !txtAneurisma.getText().isEmpty() || !txtEstenosis.getText().isEmpty()){
                    String examenMRA = String.format( "Examen MRA.%n" +
                            lbProtuberancia.getText() + txtProtuberancia.getText() + "%n" + 
                            lbAneurisma.getText() + txtAneurisma.getText() + "%n" +
                            lbEstenosis.getText() + txtEstenosis.getText() + "%n");
                    //Se agrega el examen
                    gestorPrincipal.addExamen(examenMRA, cedula);
                }

                //Alergias
                if(!txtHuevo.getText().isEmpty() || !txtLeche.getText().isEmpty() || !txtNueces.getText().isEmpty() || !txtMariscos.getText().isEmpty()){
                    String examenAlergias = String.format( "Alergias.%n" +
                            lbHuevo.getText() + txtHuevo.getText() + "%n" + 
                            lbLeche.getText() + txtLeche.getText() + "%n" +
                            lbNueces.getText() + txtNueces.getText() + "%n" +
                            lbMariscos.getText() + txtMariscos.getText() + "%n");
                    //Se agrega el examen
                    gestorPrincipal.addExamen(examenAlergias, cedula);
                }
                
//                expediente.agregarExamen(String.format(lbHematocrito.getText() + txtHematocrito.getText()
//                        + lbHemoglobina.getText() + txtHemoglobina.getText() + "%n"
//                        + lbLeucocitos.getText() + txtLeucocitos.getText() + "%n"
//                        + lbSegmentados.getText() + txtSegmentados.getText() + "%n"
//                        + lbLinfocitos.getText() + txtLinfocitos.getText() + "%n"
//                        + lbECG.getText() + txtECG.getText() + "%n"
//                        + lbInterPR.getText() + txtInterPR.getText() + "%n"
//                        + lbAlteracionesST.getText() + txtAlteracionesST.getText() + "%n"
//                        + lbFrecuencia.getText() + txtFrecuencia.getText() + "%n"
//                        + lbEjeCorazon.getText() + txtEjeCorazon.getText() + "\n"
//                        + lbFracturas.getText() + txtFracturas.getText() + "%n"
//                        + lbInfarto.getText() + txtInfarto.getText() + "%n"
//                        + lbCalcificacion.getText() + txtCalcificacion.getText() + "%n"
//                        + lbHemorragia.getText() + txtHemorragia.getText() + "%n"
//                        + lbTrauma.getText() + txtTrauma.getText() + "%n"
//                        + lbProtuberancia.getText() + txtProtuberancia.getText() + "%n"
//                        + lbAneurisma.getText() + txtAneurisma.getText() + "%n"
//                        + lbEstenosis.getText() + txtEstenosis.getText() + "%n"
//                        + lbHuevo.getText() + txtHuevo.getText() + "%n"
//                        + lbLeche.getText() + txtLeche.getText() + "%n"
//                        + lbNueces.getText() + txtNueces.getText() + "%n"
//                        + lbMariscos.getText() + txtMariscos.getText() + "%n"));
//                gestorPrincipal.addExamen(expediente);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        estado.mostrarMensaje("Examen Agregado" + arg);
    }

    //Atributos
    private Control gestorPrincipal;
    private BarraEstado estado;
    GridBagConstraints gbc = new GridBagConstraints();
    /*Paneles*/
    private JPanel panelSangre;
    private JPanel panelPrincipalSangre;
    private JPanel panelEncabezado;
    private JTabbedPane tabPanel;
    /*TXTFields*/
    private JTextField txtHematocrito;
    private JTextField txtHemoglobina;
    private JTextField txtLeucocitos;
    private JTextField txtSegmentados;
    private JTextField txtLinfocitos;

    private JTextField txtECG;
    private JTextField txtInterPR;
    private JTextField txtAlteracionesST;
    private JTextField txtFrecuencia;
    private JTextField txtEjeCorazon;

    private JTextField txtFracturas;
    private JTextField txtInfarto;
    private JTextField txtCalcificacion;
    private JTextField txtHemorragia;
    private JTextField txtTrauma;

    private JTextField txtProtuberancia;
    private JTextField txtAneurisma;
    private JTextField txtEstenosis;

    private JTextField txtHuevo;
    private JTextField txtLeche;
    private JTextField txtNueces;
    private JTextField txtMariscos;

    /*Labels*/
    private JLabel lbCedula;

    private JLabel lbSangre;
    private JLabel lbElectroCardio;
    private JLabel lbTAC;
    private JLabel lbMRA;
    private JLabel lbAlergia;

    private JLabel lbHematocrito;
    private JLabel lbHemoglobina;
    private JLabel lbLeucocitos;
    private JLabel lbSegmentados;
    private JLabel lbLinfocitos;

    private JLabel lbECG;
    private JLabel lbFrecuencia;
    private JLabel lbInterPR;
    private JLabel lbAlteracionesST;
    private JLabel lbEncabezado;
    private JLabel lbEjeCorazon;

    private JLabel lbFracturas;
    private JLabel lbInfarto;
    private JLabel lbCalcificacion;
    private JLabel lbHemorragia;
    private JLabel lbTrauma;

    private JLabel lbProtuberancia;
    private JLabel lbAneurisma;
    private JLabel lbEstenosis;

    private JLabel lbHuevo;
    private JLabel lbLeche;
    private JLabel lbNueces;
    private JLabel lbMariscos;
    /*Botones*/
    private JButton btnAgregar;
    /*Colores*/
    private Color clrLetraLabels;
    /*JComboBox*/
    private JComboBox cmbCedula;
    private List<Integer> cedulas;
}

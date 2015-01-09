/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class VentanaExamen extends JPanel {

    public VentanaExamen(Control nuevoGestor) {
        gestorPrincipal = nuevoGestor;
        ajustarConfigInic();
        ajustarComponentes();
        estado.mostrarMensaje("Programa iniciado ...");
    }

    private void ajustarConfigInic() {
        setSize(800, 400);
    }

    private void ajustarComponentes() {
        estado = new BarraEstado();
        //inicializamos Colores
        clrLetraLabels = new Color(204, 204, 204);
        //inicializamos Paneles
        panelElectroRad = new JPanel(new GridBagLayout());
        panelRadiografia = new JPanel(new GridBagLayout());
        panelSangre = new JPanel(new GridBagLayout());
        panelPrincipalSangre = new JPanel(new BorderLayout());
        panelTAC = new JPanel(new GridBagLayout());
        panelUltraSon = new JPanel(new GridBagLayout());
        panelEncabezado = new JPanel();
        panelUltraSon = new JPanel(new GridBagLayout());
        tabPanel = new JTabbedPane();
        //inicializamos TXTFields
        txtHematocrito = new JTextField(10);
        txtHemoglobina = new JTextField(10);
        txtLeucocitos = new JTextField(10);
        txtSegmentados = new JTextField(10);
        txtLinfocitos = new JTextField(10);
        //inicializamos Labels
        lbHematocrito = new JLabel("Hematocrito: ");
        lbHemoglobina = new JLabel("Hemoglobina: ");
        lbLeucocitos = new JLabel("Leucocitos: ");
        lbSegmentados = new JLabel("Segmentados: ");
        lbLinfocitos = new JLabel("Linfocitos: ");
        lbEncabezado = new JLabel("Use el Formulario para agregar examenes a los expedientes.");
        //Ajustamos Labels
        lbHematocrito.setForeground(clrLetraLabels);
        lbHemoglobina.setForeground(clrLetraLabels);
        lbLeucocitos.setForeground(clrLetraLabels);
        lbSegmentados.setForeground(clrLetraLabels);
        lbLinfocitos.setForeground(clrLetraLabels);
        lbEncabezado.setForeground(new Color(204, 204, 204));
        //inicializamos Botones
        btnAgregar = new JButton("Agregar");
        //Ajustamos panelEncabezado
        panelEncabezado.add(lbEncabezado);
        panelEncabezado.setBackground(new Color(51, 51, 51));
        panelEncabezado.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        //Ajustamos panelSangre
        panelSangre.setBackground(new Color(102, 102, 102));
        panelSangre.setPreferredSize(new Dimension(750, 500));
        panelSangre.setBorder(new CompoundBorder(new EmptyBorder(100, 100, 100, 100), BorderFactory.createTitledBorder("Formulario Examen de Sangre")));
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSangre.add(lbHematocrito, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHematocrito, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelSangre.add(lbHemoglobina, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtHemoglobina, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelSangre.add(lbLeucocitos, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtLeucocitos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelSangre.add(lbSegmentados, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtSegmentados, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelSangre.add(lbLinfocitos, gbc);
        gbc.gridx = 1;
        panelSangre.add(txtLinfocitos, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelSangre.add(btnAgregar, gbc);
        
        panelPrincipalSangre.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipalSangre.setBackground(new Color(102, 102, 102));
        panelPrincipalSangre.add(panelEncabezado, gbc);
        gbc.gridy = 1;
        panelPrincipalSangre.add(panelSangre, gbc);
        gbc.gridy = 2;
        panelPrincipalSangre.add(estado, gbc);

        //Ajustamos tabPanel
        tabPanel.add("Sangre", panelPrincipalSangre);

        //Ajustamos this
        this.setBackground(new Color(102, 102, 102));
        this.add(tabPanel);
    }

    //Atributos
    private Control gestorPrincipal;
    private BarraEstado estado;
    GridBagConstraints gbc = new GridBagConstraints();
    /*Paneles*/
    private JPanel panelTAC;
    private JPanel panelPrincipalTAC;
    private JPanel panelSangre;
    private JPanel panelPrincipalSangre;
    private JPanel panelElectroRad;
    private JPanel panelPrincipalElectroRad;
    private JPanel panelUltraSon;
    private JPanel panelPrincipalUltraSon;
    private JPanel panelRadiografia;
    private JPanel panelPrincipalRadiografia;
    private JPanel panelEncabezado;
    private JTabbedPane tabPanel;
    /*TXTFields*/
    private JTextField txtHematocrito;
    private JTextField txtHemoglobina;
    private JTextField txtLeucocitos;
    private JTextField txtSegmentados;
    private JTextField txtLinfocitos;
    /*Labels*/
    private JLabel lbHematocrito;
    private JLabel lbHemoglobina;
    private JLabel lbLeucocitos;
    private JLabel lbSegmentados;
    private JLabel lbLinfocitos;
    private JLabel lbEncabezado;
    /*Botones*/
    private JButton btnAgregar;
    /*Colores*/
    private Color clrLetraLabels;
}

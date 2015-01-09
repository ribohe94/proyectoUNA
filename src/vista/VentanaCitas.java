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
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import modelo.Cita;

public class VentanaCitas extends JPanel implements Observer {

    public VentanaCitas(Control nuevoGestor) {
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
        //Inicializamos paneles
        panelPrincipal = new JPanel(new BorderLayout());
        panelEncabezado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFormulario = new JPanel(new GridBagLayout());
        //Inicializamos JLabel
        lbEncabezado = new JLabel("Llene el siguiente formulario con la información solicitada para asignar la cita.");
        lbFecha = new JLabel(" Fecha: ");
        lbHora = new JLabel("Hora: ");
        lbMinutos = new JLabel("Minutos: ");
        lbCedulaPaciente = new JLabel("Ced. paciente: ");
        lbIdDoctor = new JLabel("Id del Doctor: ");
        //Ajustamos labels
        lbEncabezado.setForeground(new Color(204, 204, 204));
        lbFecha.setForeground(new Color(204, 204, 204));
        lbHora.setForeground(new Color(204, 204, 204));
        lbMinutos.setForeground(new Color(204, 204, 204));
        lbCedulaPaciente.setForeground(new Color(204, 204, 204));
        lbIdDoctor.setForeground(new Color(204, 204, 204));
        //Inicializamos TXT
        txtFecha = new JTextField(8);
        txtHora = new JTextField(8);
        txtMinutos = new JTextField(8);
        txtCedulaPaciente = new JTextField(8);
        txtIdDoctor = new JTextField(8);
        //Inicializamos Botones
        btnAsignarCita = new JButton("Asignar Cita");
        //Inicializamos opciones y Menu
        opcHora = new String[24];
        opcMinutos = new String[60];
        opcAgno = new String[3];
        opcDia = new String[31];
        opcDia30 = new String[30];
        opcDia29 = new String[29];
        opcDia28 = new String[28];
        for (int i = 0; i < 24; i++) {
            if (i > 9) {
                opcHora[i] = (String.valueOf(i) + ":00");
            } else {
                opcHora[i] = ("0" + String.valueOf(i) + ":00");
            }
        }
        for (int i = 0; i < 60; i++) {
            if (i > 9) {
                opcMinutos[i] = ("00:" + String.valueOf(i));
            }
            if (i < 10) {
                opcMinutos[i] = ("00:0" + String.valueOf(i));
            }
        }
        int agno = 2015;
        for (int i = 0; i < 3; i++) {
            opcAgno[i] = String.valueOf(agno);
            agno++;
        }
        int dia = 1;
        for (int i = 0; i < 31; i++) {
            opcDia[i] = String.valueOf(dia);
            dia++;
        }
        dia = 1;
        for (int i = 0; i < 30; i++) {
            opcDia30[i] = String.valueOf(dia);
            dia++;
        }
        dia = 1;
        for (int i = 0; i < 29; i++) {
            opcDia29[i] = String.valueOf(dia);
            dia++;
        }
        dia = 1;
        for (int i = 0; i < 28; i++) {
            opcDia28[i] = String.valueOf(dia);
            dia++;
        }
        cmbHoras = new JComboBox(opcHora);
        cmbMinutos = new JComboBox(opcMinutos);
        cmbAgno = new JComboBox(opcAgno);
        cmbMes = new JComboBox(opcMes);
        cmbDia = new JComboBox(opcDia);
        //Ajustamos panelFormulario
        panelFormulario.setBackground(new Color(102, 102, 102));
        panelFormulario.setPreferredSize(new Dimension(750, 500));
        panelFormulario.setBorder(new CompoundBorder(new EmptyBorder(100, 100, 100, 100), BorderFactory.createTitledBorder("Formulario Citas")));
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(lbFecha, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cmbDia, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelFormulario.add(cmbMes, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelFormulario.add(cmbAgno, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lbHora, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelFormulario.add(cmbHoras, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(lbMinutos, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelFormulario.add(cmbMinutos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lbCedulaPaciente, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelFormulario.add(txtCedulaPaciente, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelFormulario.add(lbIdDoctor, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelFormulario.add(txtIdDoctor, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        panelFormulario.add(btnAsignarCita, gbc);
        gbc.gridwidth = 1;
        //Ajustamos panelEncabezado
        panelEncabezado.add(lbEncabezado);
        panelEncabezado.setBackground(new Color(51, 51, 51));
        panelEncabezado.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        //Ajustamos panelPrincipal     
        panelPrincipal.setBorder(BorderFactory.createEtchedBorder());
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(estado, BorderLayout.SOUTH);

        //Ajustamos Tgis
        setBackground(new Color(102, 102, 102));
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panelPrincipal, gbc);
    }

    private void ajustarEventos() {

        cmbMes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbMes.getSelectedIndex() == 0) { // Enero
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 1) { // Febrero
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia28));
                }
                if (cmbMes.getSelectedIndex() == 2) { // Marzo
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 3) { // Abril
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia30));
                }
                if (cmbMes.getSelectedIndex() == 4) { // Mayo
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 5) { // Junio
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia30));
                }
                if (cmbMes.getSelectedIndex() == 6) { // Julio
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 7) { // Agosto
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 8) { // Septiembre
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia30));
                }
                if (cmbMes.getSelectedIndex() == 9) { // Octubre
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
                if (cmbMes.getSelectedIndex() == 10) { // Noviembre
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia30));
                }
                if (cmbMes.getSelectedIndex() == 11) { // Diciembre
                    cmbDia.setModel(new DefaultComboBoxModel(opcDia));
                }
            }
        });

        btnAsignarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = txtFecha.getText();
                String id = txtIdDoctor.getText();
                int hora, minutos, cedula, dia, mes, agno;

                try {
                    dia = Integer.parseInt(cmbDia.getSelectedItem().toString());
                    System.out.println(dia);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La Fecha ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    mes = cmbMes.getSelectedIndex() + 1;
                    System.out.println(mes);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La Fecha ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    agno = Integer.parseInt(cmbAgno.getSelectedItem().toString());
                    System.out.println(agno);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La Fecha ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    hora = cmbHoras.getSelectedIndex();
                    System.out.println(hora);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La Hora ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    minutos = Integer.parseInt(cmbMinutos.getSelectedItem().toString());
                    System.out.println(minutos);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Los Minutos ingresados no son válidos.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    cedula = Integer.parseInt(txtCedulaPaciente.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "La Cédula ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!gestorPrincipal.buscarPaciente(cedula)) {
                    JOptionPane.showMessageDialog(null, "El paciente no aparece dentro de la lista de asegurados.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!gestorPrincipal.buscarDoctor(id)) {
                    JOptionPane.showMessageDialog(null, "No exise éste doctor en el registro.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!gestorPrincipal.disponibilidadDoctor(id)) {
                    JOptionPane.showMessageDialog(null, "El doctor no se encuentra disponible en éste momento.", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cita nuevaCita = new Cita(fecha, hora, minutos, cedula, id);
                gestorPrincipal.asignarCita(nuevaCita);
                JOptionPane.showMessageDialog(null, "Se ha asignado la cita exitosamente.", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void iniciar() {
        gestorPrincipal.registrar(this);
        estado.mostrarMensaje("Programa iniciado ...");
        setVisible(true);
    }

    @Override
    public void update(Observable modelo, Object evento) {
        if (evento instanceof String) {
            estado.mostrarMensaje(((String) evento));
        } else {
            if (evento instanceof Cita) {
                String fechaC = ((Cita) evento).getFecha();
                int cedulaC = ((Cita) evento).getCedula();
                String idC = ((Cita) evento).getId();

                estado.mostrarMensaje(String.format("Se asignó la cita: %s, %d, %s", fechaC, cedulaC, idC));
            }
        }
    }

    //Atributo
    //Control
    private Control gestorPrincipal;
    //BarraEstado
    private BarraEstado estado;
    //JPanel
    private JPanel panelPrincipal;
    private JPanel panelFormulario;
    private JPanel panelEncabezado;
    //JLabel
    private JLabel lbEncabezado;
    private JLabel lbFecha;
    private JLabel lbHora;
    private JLabel lbMinutos;
    private JLabel lbCedulaPaciente;
    private JLabel lbIdDoctor;
    //TXT
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtMinutos;
    private JTextField txtCedulaPaciente;
    private JTextField txtIdDoctor;
    //Botones
    private JButton btnAsignarCita;
    //Menu
    private JComboBox cmbHoras;
    private JComboBox cmbMinutos;
    private JComboBox cmbDia;
    private JComboBox cmbMes;
    private JComboBox cmbAgno;
    private String[] opcHora;
    private String[] opcMinutos;
    private String[] opcDia;
    private String[] opcDia30;
    private String[] opcDia29;
    private String[] opcDia28;
    private String[] opcMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    private String[] opcAgno;
}

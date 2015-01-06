
package vista;

import java.awt.BorderLayout;
import java.util.Observer;
import controlador.Control;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Cita;
import modelo.Doctor;
import modelo.Modelo;

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
        lbFecha = new JLabel("Fecha: ");
        lbHora = new JLabel("Hora: ");
        lbMinutos = new JLabel("Minutos: ");
        lbCedulaPaciente = new JLabel("Ced. paciente: ");
        lbIdDoctor = new JLabel("Id del Doctor: "); 
        //Inicializamos TXT
        txtFecha = new JTextField(8);    
        txtHora = new JTextField(8);   
        txtMinutos = new JTextField(8);   
        txtCedulaPaciente = new JTextField(8);   
        txtIdDoctor = new JTextField(8);   
        //Inicializamos Botones
        btnAsignarCita = new JButton("Asignar Cita");           
        //Ajustamos panelFormulario
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(lbFecha, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelFormulario.add(txtFecha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lbHora, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelFormulario.add(txtHora, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(lbMinutos, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelFormulario.add(txtMinutos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lbCedulaPaciente, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelFormulario.add(txtCedulaPaciente, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelFormulario.add(lbIdDoctor, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelFormulario.add(txtIdDoctor, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btnAsignarCita, gbc);        
        //Ajustamos panelEncabezado
        panelEncabezado.add(lbEncabezado);
        //Ajustamos panelPrincipal                        
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);        
        
        
        add(panelPrincipal);
        add(estado, BorderLayout.SOUTH);
    }   
    
    private void ajustarEventos(){
        btnAsignarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String fecha = txtFecha.getText();
                String id = txtIdDoctor.getText();
                int hora, minutos, cedula;
                
                try{hora = Integer.parseInt(txtHora.getText());}
                    catch(Exception ex){JOptionPane.showMessageDialog(null, "La Hora ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);        
                    return;}
                try{minutos = Integer.parseInt(txtMinutos.getText());}                      
                    catch(Exception ex){JOptionPane.showMessageDialog(null, "Los Minutos ingresados no son válidos.", null, JOptionPane.ERROR_MESSAGE);        
                    return;}                
                try{cedula = Integer.parseInt(txtCedulaPaciente.getText());}
                    catch(Exception ex){JOptionPane.showMessageDialog(null, "La Cédula ingresada no es válida.", null, JOptionPane.ERROR_MESSAGE);        
                    return;}                                
                
                if(!gestorPrincipal.buscarPaciente(cedula)){
                    JOptionPane.showMessageDialog(null, "El paciente no aparece dentro de la lista de asegurados.", null, JOptionPane.ERROR_MESSAGE);        
                    return;
                }
                                
                if(!gestorPrincipal.buscarDoctor(id)){
                    JOptionPane.showMessageDialog(null, "No exise éste doctor en el registro.", null, JOptionPane.ERROR_MESSAGE);        
                    return;
                }
                
                if(!gestorPrincipal.disponibilidadDoctor(id)){
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
        if(evento instanceof String){
            estado.mostrarMensaje(((String)evento));
        }else{        
            if (evento instanceof Cita){                
                String fechaC = ((Cita)evento).getFecha();                
                int cedulaC = ((Cita)evento).getCedula();
                String idC = ((Cita)evento).getId();
                
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
}
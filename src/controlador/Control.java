
package controlador;
import java.util.Observer;
import javax.swing.table.TableModel;
import modelo.Doctor;
import modelo.Modelo;
import modelo.Paciente;

public class Control {
    
    public Control(Modelo nuevosDatos){
        datos = nuevosDatos;
    }
    
    public Control(){
        this(new Modelo());
    }
    
    public void registrar(Observer nuevoObservador){
        datos.addObserver(nuevoObservador);
    }
    
    public TableModel modeloTablaDoctores(){
        return datos.modeloTablaDoctores();
    }
    
    public TableModel modeloTablaPacientes(){
        return datos.modeloTablaPacientes();
    }
    
     public void cargarDatosDoctores(){
         datos.cargarDatosDoctores();
     }
     
     public void cargarDatosPacientes(){
         datos.cargarDatosPacientes();
     }
    
     public boolean agregarDoctor(Doctor nuevoDoctor){
         return datos.agregarDoctor(nuevoDoctor);
     }
     
     public void eliminarDoctor(int p){
         datos.eliminarDoctor(p);
     }
     
     public boolean agregarPaciente(Paciente nuevoPaciente){
         return datos.agregarPaciente(nuevoPaciente);
     }
     
     public void eliminarPaciente(int p){
         datos.eliminarPaciente(p);
     }
     
     public void actualizar(Object evento){
         datos.actualizar(evento);
     }

    //Atributos 
    private Modelo datos;
}
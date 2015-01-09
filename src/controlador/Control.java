
package controlador;
import java.util.Observer;
import javax.swing.table.TableModel;
import modelo.Cita;
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
         //return datos.agregarPaciente(nuevoPaciente);
         if(datos.agregarPaciente(nuevoPaciente)){
             datos.agregarExpediente(nuevoPaciente.getCedula());
             return true;
         }else{
             return false;
         }                  
     }
     
     public void eliminarPaciente(int p){
         datos.eliminarPaciente(p);
     }
     
     public boolean buscarPaciente(int cedula){
         return datos.buscarPaciente(cedula);
     }
     
     public boolean buscarDoctor(String id){
         return datos.buscarDoctor(id);
     }
     
     public boolean disponibilidadDoctor(String id){
        return datos.disponibilidadDoctor(id);
    }
     
     public void asignarCita(Cita nuevaCita){
         datos.asignarCita(nuevaCita);
     }          
     
     public String getExamenes(int cedulaPaciente){
        return datos.getExamenes(cedulaPaciente);
    }
     
     public void actualizar(Object evento){
         datos.actualizar(evento);
     }

    //Atributos 
    private Modelo datos;
}
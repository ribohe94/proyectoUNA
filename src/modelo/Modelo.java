
package modelo;

import java.util.Observable;
import javax.swing.table.TableModel;

public class Modelo extends Observable{
    
    public Modelo(){
        doctores = new ConjuntoDoctores();
        pacientes = new ConjuntoPacientes();
        expedientes = new ConjuntoExpedientes();
        modeloTablaDoctores = new ModeloTablaDoctores(doctores);    
        modeloTablaPacientes = new ModeloTablaPacientes(pacientes);
    }
    
    public TableModel modeloTablaDoctores(){
        return modeloTablaDoctores;
    }
    
    public TableModel modeloTablaPacientes(){
        return modeloTablaPacientes;
    }
    
    public void cargarDatosDoctores(){
        doctores.cargar();
        actualizar("Carga completada ...");
    }
    
    public void cargarDatosPacientes(){
        pacientes.cargar();
        actualizar("Carga completada ...");
    }
    
    public boolean agregarDoctor(Doctor nuevoDoctor){        
        boolean respuesta = doctores.agregar(nuevoDoctor);
        actualizar(nuevoDoctor); 
        return respuesta;       
    }
    
    public void eliminarDoctor(int p){
        actualizar(doctores.eliminar(p));
    }
    
    public boolean buscarDoctor(String id){
        return doctores.buscarDoctor(id);
    }
    
    public boolean disponibilidadDoctor(String id){
        return doctores.doctorDisponible(id);
    }
    
    public boolean agregarPaciente(Paciente nuevoPaciente){        
        boolean respuesta = pacientes.agregar(nuevoPaciente);
        actualizar(nuevoPaciente); 
        return respuesta;       
    }
    
    public void eliminarPaciente(int p){
        actualizar(pacientes.eliminar(p));
    }
    
    public int numPacientes(){
        return pacientes.numPersonas();
    }
    
    public boolean buscarPaciente(int cedula){
        return pacientes.buscarPaciente(cedula);
    }
    
    public Paciente recuperarPaciente(int p){
        return pacientes.recuperar(p);
    }
    
    public void asignarCita(Cita nuevaCita){
        actualizar(nuevaCita);
    }
    
    public void agregarExpediente(int cedulaPaciente){
        Expediente expediente = new Expediente(cedulaPaciente);
        expedientes.agregar(expediente);
        actualizar(expediente);
    }
    
    public void addExpediente(Expediente ex){
        expedientes.agregar(ex);
        actualizar(ex);
    }
    
    public String getExamenes(int cedulaPaciente){
        return expedientes.getExpediente(cedulaPaciente).toString();
    }
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    //Atributos
    private ConjuntoDoctores doctores;
    private ConjuntoPacientes pacientes;
    private ConjuntoExpedientes expedientes;
    private ModeloTablaDoctores modeloTablaDoctores;
    private ModeloTablaPacientes modeloTablaPacientes;
}
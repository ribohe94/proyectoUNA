
package modelo;

import java.util.Observable;
import javax.swing.table.TableModel;

public class Modelo extends Observable{
    
    //Clase que contiene todos los datos
    public Modelo(){
        doctores = new ConjuntoDoctores();
        pacientes = new ConjuntoPacientes();
        expedientes = new ConjuntoExpedientes();
        modeloTablaDoctores = new ModeloTablaDoctores(doctores);    
        modeloTablaPacientes = new ModeloTablaPacientes(pacientes);
    }
    
    //Devuelve el modelo de la tabla de los doctores
    public TableModel modeloTablaDoctores(){
        return modeloTablaDoctores;
    }
    
    //Devuelve el modelo de la tabla de los pacientes
    public TableModel modeloTablaPacientes(){
        return modeloTablaPacientes;
    }
    
    //Carga doctores de prueba 
    public void cargarDatosDoctores(){
        doctores.cargar();
        actualizar("Carga completada ...");
    }
    
    //Carga pacientes de prueba 
    public void cargarDatosPacientes(){
        pacientes.cargar();
        expedientes.cargar();
        actualizar("Carga completada ...");
    }
    
    //Agrega un nuevo doctor
    public boolean agregarDoctor(Doctor nuevoDoctor){        
        boolean respuesta = doctores.agregar(nuevoDoctor);
        actualizar(nuevoDoctor); 
        return respuesta;       
    }
    
    //Elimina un doctor
    public void eliminarDoctor(int p){
        actualizar(doctores.eliminar(p));
    }
    
    //Busca un doctor
    public boolean buscarDoctor(String id){
        return doctores.buscarDoctor(id);
    }
    
    //Devuelve la disponibilidad del doctor
    public boolean disponibilidadDoctor(String id){
        return doctores.doctorDisponible(id);
    }
    
    //Agrega un paciente
    public boolean agregarPaciente(Paciente nuevoPaciente){        
        boolean respuesta = pacientes.agregar(nuevoPaciente);
        actualizar(nuevoPaciente); 
        return respuesta;       
    }
    
    //Elimina el paciente
    public void eliminarPaciente(int p){
        actualizar(pacientes.eliminar(p));
    }
    
    //Devuelve la cantidad de pacientes
    public int numPacientes(){
        return pacientes.numPersonas();
    }
    
    //Busca un paciente
    public boolean buscarPaciente(int cedula){
        return pacientes.buscarPaciente(cedula);
    }
    
    //Devuelve un paciente
    public Paciente recuperarPaciente(int p){
        return pacientes.recuperar(p);
    }
    
    //Asigna una nueva cita
    public void asignarCita(Cita nuevaCita){
        actualizar(nuevaCita);
    }
    
    //Agrega un nuevo expediente solo con la cédula
    public void agregarExpediente(int cedulaPaciente){
        Expediente expediente = new Expediente(cedulaPaciente);
        expedientes.agregar(expediente);
        actualizar(expediente);
    }
    
    //Agrega un nuevo expediente
    public void addExamen(String ex, int cedula){
//        expedientes.agregar(ex);
        expedientes.getExpediente(cedula).agregarExamen(ex);
        
        actualizar(expedientes.getExpediente(cedula));
        //actualizar(ex);
    }
    
    //Devuelve los examenes de un paciente
    public String getExamenes(int cedulaPaciente){
        return expedientes.getExpediente(cedulaPaciente).toString();
    }
    
    //Actualiza un evento a los observadores del Modelo
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
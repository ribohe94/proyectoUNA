
package modelo;

import java.util.Observable;
import javax.swing.table.TableModel;

public class Modelo extends Observable{
    
    public Modelo(){
        doctores = new ConjuntoDoctores();
        pacientes = new ConjuntoPacientes();
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
    
    public boolean agregarPaciente(Paciente nuevoPaciente){        
        boolean respuesta = pacientes.agregar(nuevoPaciente);
        actualizar(nuevoPaciente); 
        return respuesta;       
    }
    
    public void eliminarPaciente(int p){
        actualizar(pacientes.eliminar(p));
    }
    
    public boolean buscarPaciente(int cedula){
        return pacientes.buscarPaciente(cedula);
    }
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    //Atributos
    private ConjuntoDoctores doctores;
    private ConjuntoPacientes pacientes;
    private ModeloTablaDoctores modeloTablaDoctores;
    private ModeloTablaPacientes modeloTablaPacientes;
}
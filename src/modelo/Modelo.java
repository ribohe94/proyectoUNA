
package modelo;

import java.util.Observable;
import javax.swing.table.TableModel;

public class Modelo extends Observable{
    
    public Modelo(){
        doctores = new ConjuntoDoctores();
        modeloTabla = new ModeloTablaDoctores(doctores);    
    }
    
    public TableModel modeloTabla(){
        return modeloTabla;
    }
    
    public void cargarDatos(){
        doctores.cargar();
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
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    //Atributos
    private ConjuntoDoctores doctores;
    private ModeloTablaDoctores modeloTabla;
}
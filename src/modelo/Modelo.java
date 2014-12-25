
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
    
    public void agregarDoctor(Doctor nuevoDoctor){
        doctores.agregar(nuevoDoctor);
        actualizar(nuevoDoctor);
    
    }
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    //Atributos
    private ConjuntoDoctores doctores;
    private ModeloTablaDoctores modeloTabla;
}
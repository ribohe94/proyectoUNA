
package controlador;
import java.util.Observer;
import javax.swing.table.TableModel;
import modelo.Doctor;
import modelo.Modelo;

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
    
    public TableModel modeloTabla(){
        return datos.modeloTabla();
    }
    
     public void cargarDatos(){
         datos.cargarDatos();
     }
    
     public boolean agregarDoctor(Doctor nuevoDoctor){
         return datos.agregarDoctor(nuevoDoctor);
     }
     
     public void eliminarDoctor(int p){
         datos.eliminarDoctor(p);
     }
     
     public void actualizar(Object evento){
         datos.actualizar(evento);
     }

    //Atributos 
    private Modelo datos;
}
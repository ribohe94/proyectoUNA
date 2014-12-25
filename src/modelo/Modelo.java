/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Observable;
import javax.swing.table.TableModel;

/**
 *
 * @author Bove
 */
public class Modelo extends Observable{
    
    public Modelo(){
        personas = new ConjuntoDoctores();
        
        //Al enviar al objeto personas como parámetro al 
        //modelo de la tabla, hace que el modelo de la tabla
        //manipule los mismos objetos del ArrayList de ConjuntoPersonas
        modeloTabla = new ModeloTablaDoctores(personas);
    
    }
    
    public TableModel modeloTabla(){
        return modeloTabla;
    }
    
    public void cargarDatos(){
        personas.cargar();
        //Se notifica que el modelo cambio su estado
        //porque agregó elementos al ArrayList
//        setChanged();
//        notifyObservers("Carga completada ...");
        actualizar("Carga completada ...");
    }
    
    public void agregarPersona(Doctor nuevaPersona){
        personas.agregar(nuevaPersona);
//        setChanged();
//        notifyObservers(nuevaPersona);
        actualizar(nuevaPersona);
    
    }
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    //Atributos
    private ConjuntoDoctores personas;
    private ModeloTablaDoctores modeloTabla;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.util.Observer;
import javax.swing.table.TableModel;
import modelo.Doctor;
import modelo.Modelo;

/**
 *
 * @author Bove
 */

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
    
     public void agregarPersona(Doctor nuevoDoctor){
         datos.agregarPersona(nuevoDoctor);
     }
     
     public void actualizar(Object evento){
         datos.actualizar(evento);
     }
    
     
    
    
    //Atributos 
    private Modelo datos;
    
}


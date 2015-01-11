
package modelo;

import java.util.ArrayList;

public class ConjuntoExpedientes{
    public ConjuntoExpedientes(){
        expedientes = new ArrayList<>();
    }
    
    public void agregar(Expediente nuevoExpediente){        
        expedientes.add(nuevoExpediente);        
    }
    
    public Expediente getExpediente(int cedulaPaciente){
        for(int i = 0; i < expedientes.size(); i++){
            if(expedientes.get(i).getCedulaPaciente() == cedulaPaciente){
                return expedientes.get(i);
            }
        }
        return new Expediente(0);   //No sucederá por la validación anteriormente creada
    }
    
    public Expediente eliminar(int p){
        return expedientes.remove(p);
    }
    
    public void cargar(){
        agregar(new Expediente(9013429));        
        //Agregar examenes de prueba
    }    

    //Atributos
    private ArrayList<Expediente> expedientes;
}
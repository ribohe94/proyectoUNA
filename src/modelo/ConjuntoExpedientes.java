
package modelo;

import java.util.ArrayList;

    //Clase que almacena un conjunto de Expedientes
public class ConjuntoExpedientes{
    public ConjuntoExpedientes(){
        expedientes = new ArrayList<>();
    }
    
    //Agrega un nuevo expediente
    public void agregar(Expediente nuevoExpediente){        
        expedientes.add(nuevoExpediente);        
    }
    
    //Devuelve un expediente 
    public Expediente getExpediente(int cedulaPaciente){        
        for(int i = 0; i < expedientes.size(); i++){
            if(expedientes.get(i).getCedulaPaciente() == cedulaPaciente){
                return expedientes.get(i);
            }
        }
        System.out.println("Aquí");
        return new Expediente(0);   //No sucederá por la validación anteriormente creada
    }
    
    //Se elimina un expediente
    public Expediente eliminar(int p){
        return expedientes.remove(p);
    }
    
    //Carga expedientes de prueba
    public void cargar(){
        agregar(new Expediente(9013429));        
        agregar(new Expediente(9013428));    
        agregar(new Expediente(9013427));    
        agregar(new Expediente(9013425));    
        agregar(new Expediente(9013422));    
    }    

    //Atributos
    private ArrayList<Expediente> expedientes;
}
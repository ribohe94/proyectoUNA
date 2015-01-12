
package modelo;

import java.util.ArrayList;

    //Clase que define atributos y métodos de los Doctores
public class Expediente {
    public Expediente(int nuevaCedula){
        cedulaPaciente = nuevaCedula;
        examenes = new ArrayList<>();
    }
    
    //Agrega un nuevo examen
    public void agregarExamen(String nuevoExamen){               
        examenes.add(nuevoExamen);
    }
    
    //Devuelve la cedula del paciente
    public int getCedulaPaciente(){
        return cedulaPaciente;
    }
    
    //Devuelve todos los examenes del expediente
    @Override
    public String toString(){                      
        String r = "";
        for(int i = 0; i < examenes.size(); i++){
            r += examenes.get(i);
            r += String.format("%n");
        }
        return r;
    }
    
    //Atributos
    private int cedulaPaciente;
    private ArrayList<String> examenes;
}

package modelo;

import java.util.ArrayList;

public class Expediente {
    public Expediente(int nuevaCedula){
        cedulaPaciente = nuevaCedula;
        examenes = new ArrayList<>();
    }
    
    public void agregarExamen(String nuevoExamen){               
        examenes.add(nuevoExamen);
    }
    
    public int getCedulaPaciente(){
        return cedulaPaciente;
    }
    
    @Override
    public String toString(){
        return String.format("Paciente : " + cedulaPaciente + "%n" + examenes.toString());        
    }
    
    //Atributos
    private int cedulaPaciente;
    private ArrayList<String> examenes;
}

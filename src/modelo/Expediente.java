
package modelo;

import java.util.ArrayList;

public class Expediente {
    public Expediente(Paciente nuevoPaciente){
        paciente = nuevoPaciente;
        examenes = new ArrayList<>();
    }
    
    public Paciente getPaciente(){
        return paciente;
    }
    
    public void agregarExamen(String nuevoExamen){               
        examenes.add(nuevoExamen);
    }
    
    public int getCedulaPaciente(){
        return paciente.getCedula();
    }
    
    @Override
    public String toString(){
        return String.format(paciente.getCedula() + ", " + paciente.getApellidos() + ", " + paciente.getNombre() + "." + "%n" + examenes.toString());        
    }
    
    //Atributos
    private Paciente paciente;
    private ArrayList<String> examenes;
}

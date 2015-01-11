
package modelo;

import java.util.ArrayList;

public class ConjuntoPacientes{
    public ConjuntoPacientes(){
        pacientes = new ArrayList<>();
    }
    
    public boolean agregar(Paciente nuevoPaciente){        
         if(buscarPaciente(nuevoPaciente.getCedula())){
            return false;
        }else{
            pacientes.add(nuevoPaciente);
            return true; 
        }                 
    }
    
    public Paciente eliminar(int p){
        return pacientes.remove(p);
    }
    
    public boolean buscarPaciente(int buscarCedula){
        for(int i = 0; i<pacientes.size(); i++){
            if(pacientes.get(i).getCedula() == buscarCedula){
                return true;                
            }            
        }
        return false;
    }
    
    public Paciente recuperar(int p){
        return pacientes.get(p);
    }
    
    public int numPersonas(){
        return pacientes.size();
    }
    
    public void cargar(){
        agregar(new Paciente(9013429, "Esteban", "Mercado Hernández", 20, 60));        
        agregar(new Paciente(9013428, "Esteban", "Mercado Hernández", 20, 60));        
        agregar(new Paciente(9013427, "Esteban", "Mercado Hernández", 20, 60));        
        agregar(new Paciente(9013425, "Esteban", "Mercado Hernández", 20, 60));        
        agregar(new Paciente(9013422, "Esteban", "Mercado Hernández", 20, 60));        
    }

    //Atributos
    private ArrayList<Paciente> pacientes;
}
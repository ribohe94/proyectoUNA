
package modelo;

import java.util.ArrayList;

public class ConjuntoDoctores {
    public ConjuntoDoctores(){
        doctores = new ArrayList<>();
    }
    
    public boolean agregar(Doctor nuevoDoctor){        
         if(buscarDoctor(nuevoDoctor.getId())){
            return false;
        }else{
            doctores.add(nuevoDoctor);
            return true; 
        }                 
    }
    
    public Doctor eliminar(int p){
        return doctores.remove(p);
    }

    
    public boolean buscarDoctor(String buscarId){
        for(int i = 0; i<doctores.size(); i++){
            if(doctores.get(i).getId().compareTo(buscarId) == 0){
                return true;                
            }            
        }
        return false;
    }
    
    public Doctor recuperar(int p){
        return doctores.get(p);
    }
    
    public int numPersonas(){
        return doctores.size();
    }
    
    public void cargar(){
        agregar(new Doctor("Riccardo", "Bove", "116310708", 20, true));

    }

    //Atributos
    private ArrayList<Doctor> doctores;
}
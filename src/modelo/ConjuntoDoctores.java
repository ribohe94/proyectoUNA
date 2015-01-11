
package modelo;

import java.util.ArrayList;

    //Clase que almacena un conjunto de Doctores
public class ConjuntoDoctores{
    public ConjuntoDoctores(){
        doctores = new ArrayList<>();
    }
    
    //Agrega un nuevo doctor
    public boolean agregar(Doctor nuevoDoctor){        
         if(buscarDoctor(nuevoDoctor.getId())){
            return false;
        }else{
            doctores.add(nuevoDoctor);
            return true; 
        }                 
    }
    
    //Elimina un doctor
    public Doctor eliminar(int p){
        return doctores.remove(p);
    }
    
    //Busca un doctor
    public boolean buscarDoctor(String buscarId){
        for(int i = 0; i<doctores.size(); i++){
            if(doctores.get(i).getId().compareTo(buscarId) == 0){
                return true;                
            }            
        }
        return false;
    }
    
    //Devuelve la disponibilidad de un doctor
    public boolean doctorDisponible(String id){
        for(int i = 0; i<doctores.size(); i++){
            if(doctores.get(i).getId().compareTo(id) == 0){
                return doctores.get(i).getDisponible();
            }            
        }        
        return false;
    }
    
    //Devuelve un doctor
    public Doctor recuperar(int p){
        return doctores.get(p);
    }
    
    //Devuelve la cantidad de doctores
    public int numPersonas(){
        return doctores.size();
    }
    
    //Carga un doctor de prueba
    public void cargar(){
        agregar(new Doctor("Riccardo", "Bove", "116310708", 20, true));
    }

    //Atributos
    private ArrayList<Doctor> doctores;
}
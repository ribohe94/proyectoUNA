
package modelo;

import java.util.ArrayList;

public class ConjuntoDoctores {
    public ConjuntoDoctores(){
        doctores = new ArrayList<>();
    }
    
    public void agregar(Doctor nuevoDoctor){
        doctores.add(nuevoDoctor);
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
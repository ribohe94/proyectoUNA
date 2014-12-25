/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 *
 * @author Bove
 */
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
//        System.out.println("Entre al método cargar");
        agregar(new Doctor("Riccardo", "Bove", "116310708", 20));
//        agregar(new Persona("123455", "Solis Mora", "José", 1.70, true));
//        agregar(new Persona("345617", "Mena Quirós", "Melissa", 1.65, false));
//        agregar(new Persona("457180", "Fuentes Alvarado", "Karen", 1.52, true));
//        agregar(new Persona("123455", "Jiménez Jiménez", "Nanyeli", 1.55, false));
//        System.out.println("Cantidad de personas" + personas.size());
    
    }
    
    
    
    //Atributos
    private ArrayList<Doctor> doctores;
}

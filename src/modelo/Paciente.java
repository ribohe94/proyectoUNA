
package modelo;

public class Paciente {
    public Paciente(int edad, float peso, String nombre, String apellidos, int cedula){
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    //ATRIBUTOS
    private int edad;
    private float peso;
    private String nombre;
    private String apellidos;
    private int cedula;
}
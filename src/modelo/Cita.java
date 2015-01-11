
package modelo;

    //Clase que define atributos y métodos de las citas
public class Cita {
    public Cita(String fecha, int hora, int minutos, int cedula, String id){
        this.fecha = fecha;
        this.hora = hora;
        this.minutos = minutos;
        this.cedula = cedula;
        this.id = id;
    }
    
    //Devuelve la fecha de la cita
    public String getFecha(){
        return fecha;
    }
    
    //Devuelve la hora de la cita
    public int getHora(){
        return hora;
    }
    
    //Devuelve los minutos de la cita
    public int getMinutos(){
        return minutos;
    }
    
    //Devuelve la cedula del paciente de la cita
    public int getCedula(){
        return cedula;
    }
    
    //Devuelve el ID del doctor de la cita
    public String getId(){
        return id;
    }
    
    //Atributos
    private String fecha;
    private int hora;
    private int minutos;
    private int cedula;
    private String id;            
}
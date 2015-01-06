
package modelo;

public class Cita {
    public Cita(String fecha, int hora, int minutos, int cedula, String id){
        this.fecha = fecha;
        this.hora = hora;
        this.minutos = minutos;
        this.cedula = cedula;
        this.id = id;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public int getHora(){
        return hora;
    }
    
    public int getMinutos(){
        return minutos;
    }
    
    public int getCedula(){
        return cedula;
    }
    
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
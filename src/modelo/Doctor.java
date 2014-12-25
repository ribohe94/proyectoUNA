/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Bove
 */
public class Doctor {

    public Doctor() {
    }

    public Doctor(String nombre, String apellido, String id, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getId();
        r[1] = getApellido();
        r[2] = getNombre();
        r[3] = getEdad();
        return r;
    }

    public void fijarAtributo(Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0:
                setId(aValue.toString());
                break;
            case 1:
                setApellido(aValue.toString());
                break;
            case 2:
                setNombre(aValue.toString());
                break;
            case 3:
                setEdad(((int) aValue));
            default:
                throw new IndexOutOfBoundsException();
        }

    }
    
    public static String[] nombreCampos(){
        return NOMBRE_CAMPOS;
    }
    
    public static int numCampos(){
        return Doctor.class.getClass().getFields().length;
    }
    
    @Override
    public String toString(){
        return String.format("%s, %s %s, %f5.2",
                getId(), getApellido(), getNombre(), getEdad());
    }

    //Atributos
    String nombre;
    String apellido;
    String id;
    int edad;
    
    private static final String[] NOMBRE_CAMPOS = {"Id", "Apellido", "Nombre", "Edad"};
}

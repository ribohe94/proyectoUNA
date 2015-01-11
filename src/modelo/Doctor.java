
package modelo;

    //Clase que define atributos y métodos de los Doctores
public class Doctor {

    public Doctor() {
    }

    public Doctor(String nombre, String apellido, String id, int edad, boolean disponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.edad = edad;
        this.disponible = disponible;
    }

    //Devuelve el nombre del doctor
    public String getNombre() {
        return nombre;
    }

    //Ajusta el nombre del doctor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Devuelve el apellido del doctor
    public String getApellido() {
        return apellido;
    }

    //Ajusta el apellido del doctor
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Devuelve el ID del doctor
    public String getId() {
        return id;
    }

    //Ajusta el ID del doctor
    public void setId(String id) {
        this.id = id;
    }

    //Devuelve la edad del doctor
    public int getEdad() {
        return edad;
    }

    //Ajusta la edad del doctor
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //Devuelve la disponibilidad del doctor
    public boolean getDisponible(){
        return disponible;
    }
    
    //Ajusta la disponibilidad del doctor
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    //Devuelve el arreglo de atributos del doctor
    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getId();
        r[1] = getApellido();
        r[2] = getNombre();
        r[3] = getEdad();
        r[4] = getDisponible();
        return r;
    }

    //Ajusta los atributos del doctor
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
                break;
            case 4:
                setDisponible(((boolean)aValue));
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    //Devuelve el nombre de los campos del Doctor
    public static String[] nombreCampos(){
        return NOMBRE_CAMPOS;
    }
    
    //Devuelve la cantidad de los campos del Doctor
    public static int numCampos(){
        return Doctor.class.getClass().getFields().length;
    }

    //Atributos
    private String nombre;
    private String apellido;
    private String id;
    private int edad;
    private boolean disponible;
    
    private static final String[] NOMBRE_CAMPOS = {"Id", "Apellido", "Nombre", "Edad", "Disponible"};
}
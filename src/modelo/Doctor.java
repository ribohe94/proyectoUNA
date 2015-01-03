
package modelo;

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
    
    public boolean getDisponible(){
        return disponible;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getId();
        r[1] = getApellido();
        r[2] = getNombre();
        r[3] = getEdad();
        r[4] = getDisponible();
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
                break;
            case 4:
                setDisponible(((boolean)aValue));
                break;
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

    //Atributos
    private String nombre;
    private String apellido;
    private String id;
    private int edad;
    private boolean disponible;
    
    private static final String[] NOMBRE_CAMPOS = {"Id", "Apellido", "Nombre", "Edad", "Disponible"};
}
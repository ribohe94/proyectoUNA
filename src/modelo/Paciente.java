
package modelo;

public class Paciente {
    public Paciente(int cedula, String nombre, String apellidos, int edad, float peso){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;        
        this.edad = edad;
        this.peso = peso;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getCedula();
        r[1] = getApellidos();
        r[2] = getNombre();
        r[3] = getEdad();
        r[4] = getPeso();
        return r;
    }
    
    public void fijarAtributo(Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0:
                setCedula(((int)aValue));
                break;
            case 1:
                setApellidos(aValue.toString());                
                break;
            case 2:
                setNombre(aValue.toString());
                break;                
            case 3:
                setEdad(((int) aValue));
                break;
            case 4:
                setPeso(((float)aValue));
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public static String[] nombreCampos(){
        return NOMBRE_CAMPOS;
    }
    
    public static int numCampos(){
        return Paciente.class.getClass().getFields().length;
    }    
    
    //ATRIBUTOS
    private int edad;
    private float peso;
    private String nombre;
    private String apellidos;
    private int cedula;
    
    private static final String[] NOMBRE_CAMPOS = {"Cedula", "Apellidos", "Nombre", "Edad", "Peso"};
}
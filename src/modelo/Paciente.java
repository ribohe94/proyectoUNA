
package modelo;

    //Clase que define atributos y métodos de los Pacientes
public class Paciente {
    public Paciente(int cedula, String nombre, String apellidos, int edad, float peso){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;        
        this.edad = edad;
        this.peso = peso;
    }
    
    //Devuelve la edad del paciente
    public int getEdad(){
        return edad;
    }
    
    //Ajusta la edad del paciente
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    //Devuelve el peso del paciente
    public float getPeso(){
        return peso;
    }
    
    //Ajusta el peso del paciente
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    //Devuelve el nombre del paciente
    public String getNombre(){
        return nombre;
    }
    
    //Ajusta el nombre del paciente
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    //Devuelve los apellidos del paciente
    public String getApellidos(){
        return apellidos;
    }
    
    //Ajusta los apellidos del paciente
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    //Devuelve la cedula del paciente
    public int getCedula(){
        return cedula;
    }
    
    //Ajusta la cedula del paciente
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    //Devuelve el arreglo de atributos del paciente
    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getCedula();
        r[1] = getApellidos();
        r[2] = getNombre();
        r[3] = getEdad();
        r[4] = getPeso();
        return r;
    }
    
    //Ajusta los atributos del paciente
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
    
    //Devuelve el nombre de los campos del Paciente
    public static String[] nombreCampos(){
        return NOMBRE_CAMPOS;
    }
    
    //Devuelve la cantidad de los campos del Paciente
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
package controlador;

import java.util.Observer;
import javax.swing.table.TableModel;
import modelo.Cita;
import modelo.Doctor;
import modelo.Expediente;
import modelo.Modelo;
import modelo.Paciente;
//Clase Controladora del Modelo

public class Control {

    public Control(Modelo nuevosDatos) {
        datos = nuevosDatos;
    }

    public Control() {
        this(new Modelo());
    }
//Registra observadores al modelo

    public void registrar(Observer nuevoObservador) {
        datos.addObserver(nuevoObservador);
    }
//Devuelve el modelo de tabla de doctores

    public TableModel modeloTablaDoctores() {
        return datos.modeloTablaDoctores();
    }
//Devuelve el modelo de tabla de pacientes

    public TableModel modeloTablaPacientes() {
        return datos.modeloTablaPacientes();
    }
//Carga doctores de prueba

    public void cargarDatosDoctores() {
        datos.cargarDatosDoctores();
    }
//Carga pacientes de prueba

    public void cargarDatosPacientes() {
        datos.cargarDatosPacientes();
    }
//Agrega un nuevo doctor

    public boolean agregarDoctor(Doctor nuevoDoctor) {
        return datos.agregarDoctor(nuevoDoctor);
    }
//Elimina un doctor de la lista

    public void eliminarDoctor(int p) {
        datos.eliminarDoctor(p);
    }
//Agrega un nuevo paciente

    public boolean agregarPaciente(Paciente nuevoPaciente) {
//return datos.agregarPaciente(nuevoPaciente);
        if (datos.agregarPaciente(nuevoPaciente)) {
            datos.agregarExpediente(nuevoPaciente.getCedula());
            return true;
        } else {
            return false;
        }
    }
//Elimina un paciente de la lista

    public void eliminarPaciente(int p) {
        datos.eliminarPaciente(p);
    }
//Devuelve true si la búsqueda de un paciente es exitosa

    public boolean buscarPaciente(int cedula) {
        return datos.buscarPaciente(cedula);
    }
//Devuelve la cantidad de Pacientes registrados

    public int numPacientes() {
        return datos.numPacientes();
    }
//Devuelve el Paciente buscado

    public Paciente recuperarPaciente(int p) {
        return datos.recuperarPaciente(p);
    }
//Devuelve true si la búsqueda de un doctor es exitosa

    public boolean buscarDoctor(String id) {
        return datos.buscarDoctor(id);
    }
//Devuelve la disponibilidad del Doctor buscado

    public boolean disponibilidadDoctor(String id) {
        return datos.disponibilidadDoctor(id);
    }
//Asigna una nueva cita

    public void asignarCita(Cita nuevaCita) {
        datos.asignarCita(nuevaCita);
    }
//Agrega un nuevo expediente

    public void addExamen(String ex, int cedula) {
        datos.addExamen(ex, cedula);
    }
//Devuelve un String con todos los examenes en el expediente de un Paciente

    public String getExamenes(int cedulaPaciente) {
        return datos.getExamenes(cedulaPaciente);
    }
//Actualiza un evento del modelo a sus observadores

    public void actualizar(Object evento) {
        datos.actualizar(evento);
    }
//Atributos
    private Modelo datos;
}

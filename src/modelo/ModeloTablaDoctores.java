/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bove
 */
public class ModeloTablaDoctores extends AbstractTableModel {
    public ModeloTablaDoctores(ConjuntoDoctores doctores){
        this.doctores = doctores;
        System.out.println("Modelo Tabla Personas" + doctores.numPersonas());
    }
    
    
    @Override
    public int getRowCount() { 
        int filas = doctores.numPersonas();
        return filas;
    }

    @Override
    public int getColumnCount() {
        return Doctor.nombreCampos().length;
        //return Persona.numCampos();
    }
    
    @Override
    //Permite obtener el valor de un atributo de la persona
    //que representa la posición del ArrayList correspondiente
    //al valor
    public Object getValueAt(int rowIndex, int columnIndex) {
        return doctores.recuperar(rowIndex).toArray()[columnIndex];
    }
    
    
    //Pruebas con los siguientes métodos
    
    @Override 
    public String getColumnName(int columnIndex){
        return Doctor.nombreCampos()[columnIndex];
    }
    
    
    @Override 
    public void setValueAt(Object valor, int rowIndex, int columnIndex){
        //Actualiza el atributo de la persona
        doctores.recuperar(rowIndex).fijarAtributo(valor, columnIndex);
        //Actualiza la celda del modelo de la tabla
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        //return true;
        return (columnIndex > 0);
    }
    
    @Override
    //Permite conocer la clase asociada a la columna
    public Class getColumnClass(int columnIndex){
        return getValueAt(0, columnIndex).getClass();
    }
    
    
    //Atributo
    private ConjuntoDoctores doctores;
}

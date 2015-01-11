
package modelo;

import javax.swing.table.AbstractTableModel;

    //Clase que define el modelo de tabla para los Doctores
public class ModeloTablaDoctores extends AbstractTableModel {
    public ModeloTablaDoctores(ConjuntoDoctores doctores){
        this.doctores = doctores;        
    }    
    
    //Devuelve la cantidad de filas de la tabla
    @Override
    public int getRowCount() { 
        int filas = doctores.numPersonas();
        return filas;
    }

    //Devuelve la cantidad de filas de la tabla
    @Override
    public int getColumnCount() {
        return Doctor.nombreCampos().length;        
    }
    
    //Devuelve un objeto en cierta posición
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return doctores.recuperar(rowIndex).toArray()[columnIndex];
    }
    
    //Devuelve el nombre de la columna
    @Override 
    public String getColumnName(int columnIndex){
        return Doctor.nombreCampos()[columnIndex];
    }
        
    //Ajusta un valor en cierta posición
    @Override 
    public void setValueAt(Object valor, int rowIndex, int columnIndex){        
        doctores.recuperar(rowIndex).fijarAtributo(valor, columnIndex);        
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    //Retorna si una celda es editable o no
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return (columnIndex > 0);
    }
    
    //Devuelve la clase de la columna
    @Override
    public Class getColumnClass(int columnIndex){
        return getValueAt(0, columnIndex).getClass();
    }
        
    //Atributo
    private ConjuntoDoctores doctores;
}
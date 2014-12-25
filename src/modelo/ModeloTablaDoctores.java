
package modelo;

import javax.swing.table.AbstractTableModel;

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
    }
    
    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        return doctores.recuperar(rowIndex).toArray()[columnIndex];
    }
    
    @Override 
    public String getColumnName(int columnIndex){
        return Doctor.nombreCampos()[columnIndex];
    }
        
    @Override 
    public void setValueAt(Object valor, int rowIndex, int columnIndex){        
        doctores.recuperar(rowIndex).fijarAtributo(valor, columnIndex);        
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return (columnIndex > 0);
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        return getValueAt(0, columnIndex).getClass();
    }
        
    //Atributo
    private ConjuntoDoctores doctores;
}
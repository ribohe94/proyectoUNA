
package modelo;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaPacientes extends AbstractTableModel {
    public ModeloTablaPacientes(ConjuntoPacientes pacientes){
        this.pacientes = pacientes;        
    }    
    
    @Override
    public int getRowCount() { 
        int filas = pacientes.numPersonas();
        return filas;
    }

    @Override
    public int getColumnCount() {
        return Paciente.nombreCampos().length;        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return pacientes.recuperar(rowIndex).toArray()[columnIndex];
    }
    
    @Override 
    public String getColumnName(int columnIndex){
        return Paciente.nombreCampos()[columnIndex];
    }
        
    @Override 
    public void setValueAt(Object valor, int rowIndex, int columnIndex){        
        pacientes.recuperar(rowIndex).fijarAtributo(valor, columnIndex);        
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
    private ConjuntoPacientes pacientes;
}
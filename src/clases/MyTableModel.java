
package clases;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
      

    public MyTableModel(String codigo,String nombre) {
      super(new String[]{codigo, nombre, "Seleccion"}, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = Integer.class;
          break;
        case 2:
          clazz = Boolean.class;
          break;
      }
      return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return column == 2;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (aValue instanceof Boolean && column == 2) {
//        System.out.println(aValue);
        Vector rowData = (Vector) getDataVector().get(row);
        rowData.set(2, (boolean)aValue);
//          System.out.println(rowData.get(0));
        fireTableCellUpdated(row, column);
      }
    }
    
    public String codigo(String codigo,boolean seleccion){
        if (seleccion) {
            return codigo;
        }
        return "";
    }
  


}

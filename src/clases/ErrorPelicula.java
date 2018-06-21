
package clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ErrorPelicula extends Exception {
    

    public ErrorPelicula(String ClaseMetodo,String mensajeError){
        super(ClaseMetodo+mensajeError);
        JOptionPane.showMessageDialog(null, ClaseMetodo+"{------}"+mensajeError);
    }
    

    
}

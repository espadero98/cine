
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conexion {
     public Connection conexion;
     public  Statement st;
    
        
            
   
    public  Conexion() throws ErrorPelicula{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/cine", "root", "");  
            st = conexion.createStatement();
            
        } catch (Exception e) {
            throw new ErrorPelicula("Conexion.conexion()",e.getMessage());

        }
    }
    
    public Connection conectarBase() throws ErrorPelicula {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/cine", "root", "");
         } catch (Exception ex) {
            
         }
      }
      return conexion;
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorActor.cn;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kike
 */
public class ControladorDirector {
    
    static Conexion cn;
    static ResultSet rs,rs2;

   
   
   
    public static void Agregar(Director peli) throws ErrorPelicula{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO director(idDirector,director) VALUES('"+peli.getIdDirector()+"','"+peli.getDirector()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorDirector/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Director peli) throws ErrorPelicula{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE director SET idDirector='"+peli.getIdDirector()+"',director='"+peli.getDirector()+"' WHERE idDirector='"+peli.getIdDirector()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorDirector/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Director peli) throws ErrorPelicula{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM Director WHERE idActor='"+peli.getIdDirector()+"'");
        } catch (SQLException ex) {
            throw new ErrorPelicula("Class ControladorDirector/Modificar",ex.getMessage());
        }
                
                
            
        
    }
    
    
    public static ArrayList<Director> Buscar() throws ErrorPelicula{
        ArrayList<Object> director = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT director.idDirector,director.director FROM director");
            
                while (rs.next()) {
                    director.add(rs.getString(1));
                    director.add(rs.getString(2));
                   
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorDirector/Buscar",e.getMessage());
        }
        
        ArrayList<Director> directores=(ArrayList) director;
        
        return directores;
    }
    
    
    

    
//    // Obtiene el Binario de un Archivo en Cadena
//    public static String fnStrGetBinaryStringOfFileImage(String sFile)
//    {
//        // Para el Resultado
//        String sResult="";
//                
//        // Variable de Tipo Archivo
//        File fImg = new File(sFile);
//        
//        // Variable FileInputStream
//        FileInputStream fisImg=null;
//        
//        // Captura el Error
//        try 
//        {
//            // Lee el Stream del Archivo
//            fisImg = new FileInputStream(fImg);
//            
//            // Crea un ByteArray
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        
//            // Declara un vector de tipo Byte
//            byte[] buf = new byte[1024];
//            
//            // Ciclo para leer el Archivo
//            for (int readNum; (readNum = fisImg.read(buf)) != -1;) 
//            {
//                // Graba en la variable bos
//                bos.write(buf, 0, readNum);              
//            }
//            
//            // Convierte a Vector de Bytes
//            byte[] bytes = bos.toByteArray();
//            
//            // Variable para obtener el Dato en Entero
//            int  iDato;
//            
//            // Variable para el String del Dato
//            String sDato;
//            
//            // Ciclo para Generar el dato
//            for (int i=0; i < bytes.length; i++)
//            {
//                // Obtengo el Dato en Entero
//                iDato = bytes[i];           
//                
//                // Convertimos a Hex en Cadena
//                sDato = Integer.toHexString(iDato);
//                
//                // Eliminamos las "a"
//                sDato = sDato.replaceAll("ffffff", "");
//                
//                // Si hay un solo caracter le agrega el 0
//                if (sDato.length()==1)
//                    sDato = "0"+sDato;
//                
//                // Agregamos al Resultado
//                sResult+=sDato;
//                
//            }                
//            
//            // Agregamos el 0x
//            sResult = "0x"+sResult;
//        } 
//        
//        // Captura el Error
//        catch (FileNotFoundException ex) 
//        {
//           
//        }        
//        catch (IOException ex) 
//        {
//            ex.printStackTrace();
//        }
//                       
//        // Devuelve el Resultado
//        return sResult;        
//    }    
//    
//    public static void fnConvertInputStreamToFile(InputStream isDatos, String sFileName)
//    {
//        // Crea el archivo con el Nombre indicado
//        File f = new File(sFileName);
//        
//        // El Archivo de Salida
//        OutputStream osArchivoSalida=null;
//        
//        // Captura el Error
//        try 
//        {
//            //  Asigna al Archivo de Salida el Archivo Abierto
//            osArchivoSalida = new FileOutputStream(f);
//            
//            // Vector de Bytes
//            byte[] buf =new byte[1024];
//            
//            // Variable para lectura de Datos
//            int len;
//            
//            // Lee del InputStream
//            while((len=isDatos.read(buf))>0)
//            {
//                // Escribe al Archivo de Salida
//                osArchivoSalida.write(buf,0,len);
//            }
//            
//            // Cierra el Archivo y el InputStream
//            osArchivoSalida.close();
//            isDatos.close();        
//        } 
//        catch (FileNotFoundException ex) 
//        {
//            
//        } catch (IOException ex) {
//           
//        }
//    
//}
//    
    
//    public static Asignatura Obtener(String CodBarra, int idSucursal) throws ErrorPelicula{
//        Asignatura miproducto=new Asignatura();
//        
//        
//        cn=new Conexion();
//        try {
//            rs=cn.st.executeQuery("SELECT inventario.IdSucursal, inventario.Cantidad, inventario.CodBarra,producto.Nombre,producto.Costo FROM inventario,producto WHERE  inventario.CodBarra='"+CodBarra+"' AND inventario.IdSucursal="+idSucursal+" AND producto.CodBarra=inventario.CodBarra;");
//            while (rs.next()) {
//                miproducto.setIdSucursal(Integer.parseInt(rs.getString(1)));
//                miproducto.setCodBarra(rs.getString(3));
//                miproducto.setNombre(rs.getString(4));
//                miproducto.setInventario(Integer.parseInt(rs.getString(2)));
//                miproducto.setCosto(Double.parseDouble(rs.getString(5)));
//            }
//        } catch (SQLException e) {
//            throw new ErrorTienda("Class ControladorProducto/Obtener",e.getMessage());
//        }
//        return miproducto;
//    }
//    
 public static Director BuscarDirector(String codigo) throws ErrorPelicula{
        Director midirector = new Director();
        String codigoPeli="";
        cn = new Conexion();
        try {
            rs2=cn.st.executeQuery("SELECT * FROM peliculadirector WHERE idPelicula = '"+codigo+"';");
           while (rs2.next()) {
                
                codigoPeli=rs2.getString(2);
                System.out.println(codigoPeli);
                
            }
            rs = cn.st.executeQuery("SELECT * FROM director WHERE idDirector = '"+codigoPeli+"';");
            while (rs.next()) {
                midirector.setIdDirector(rs.getString(1));
                midirector.setDirector(rs.getString(2));
                
            }
        } catch (Exception e) {
        }
        return midirector;
    }

}


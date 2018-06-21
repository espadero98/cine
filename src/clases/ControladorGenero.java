/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
public class ControladorGenero {
    
    static Conexion cn;
    static ResultSet rs,rs2;

   
   
   
    public static void Agregar(Genero peli) throws ErrorPelicula{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO genero(idGenero,genero) VALUES('"+peli.getIdGenero()+"','"+peli.getGenero()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorMetodologia/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Genero peli) throws ErrorPelicula{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE genero SET idGenero='"+peli.getIdGenero()+"',genero='"+peli.getGenero()+"' WHERE idGenero='"+peli.getIdGenero()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorGenero/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Genero peli) throws ErrorPelicula{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM genero WHERE idGenero='"+peli.getIdGenero()+"'");
        } catch (SQLException ex) {
            throw new ErrorPelicula("Class ControladorGenero/Modificar",ex.getMessage());
        }
                
                
            
        
    }
    
    
    public static ArrayList<Genero> Buscar() throws ErrorPelicula{
        ArrayList<Object> asignatura = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT genero.idGenero,genero.genero FROM genero");
            
                while (rs.next()) {
                    asignatura.add(rs.getString(1));
                    asignatura.add(rs.getString(2));
                   
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorGenero/Buscar",e.getMessage());
        }
        
        ArrayList<Genero> generos=(ArrayList) asignatura;
        
        return generos;
    }
    
    
    
  
    
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
    public static Genero BuscarGenero(String codigo) throws ErrorPelicula{
        Genero migenero = new Genero();
        String codigoPeli="",codigooo="";
        cn = new Conexion();
        System.out.println(codigo);
        try {
            System.out.println("olaaa");
            rs=cn.st.executeQuery("SELECT * FROM peliculagenero WHERE idPelicula = '"+codigo+"'");
           while (rs.next()) {
                codigooo=rs.getString(1);
                codigoPeli=rs.getString(2);
                System.out.println(codigoPeli);
                
            }
            rs = cn.st.executeQuery("SELECT * FROM genero WHERE idGenero = '"+codigoPeli+"';");
            while (rs.next()) {
                migenero.setIdGenero(rs.getString(1));
                migenero.setGenero(rs.getString(2));
                
            }
        } catch (Exception e) {
        }
        return migenero;
    }
}


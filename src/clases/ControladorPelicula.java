/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorDirector.cn;
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
public class ControladorPelicula {
    
    static Conexion cn;
    static ResultSet rs;

   
   
   
    public static void Agregar(Pelicula peli) throws ErrorPelicula{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO pelicula(idPelicula,pelicula,duracion,estreno,sinopsis) VALUES('"+peli.getIdPelicula()+"','"+peli.getPelicula()+"','"+peli.getDuracion()+"','"+peli.getEstreno()+"','"+peli.getSinopsis()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorPelicula/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Pelicula peli) throws ErrorPelicula{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE pelicula SET idPelicula='"+peli.getIdPelicula()+"',pelicula='"+peli.getPelicula()+"',duracion='"+peli.getDuracion()+"',estreno='"+peli.getEstreno()+"',duracion='"+peli.getDuracion()+"',sinopsis='"+peli.getSinopsis()+ "' WHERE idPelicula='"+peli.getIdPelicula()+"'");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorPelicula/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Pelicula peli) throws ErrorPelicula{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM pelicula WHERE idPelicula='"+peli.getIdPelicula()+"'");
        } catch (SQLException ex) {
            throw new ErrorPelicula("Class ControladorPelicula/Modificar",ex.getMessage());
        }
                
                
            
        
    }
    
    
    public static ArrayList<Pelicula> Buscar() throws ErrorPelicula{
        ArrayList<Object> asignatura = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT pelicula.idPelicula,pelicula.pelicula,pelicula.duracion,pelicula.estreno, pelicula.sinopsis FROM pelicula");
            
                while (rs.next()) {
                    asignatura.add(rs.getString(1));
                    asignatura.add(rs.getString(2));
                    asignatura.add(rs.getString(3));
                    asignatura.add(rs.getString(4));
                    asignatura.add(rs.getString(5));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorPelicula/Buscar",e.getMessage());
        }
        
        ArrayList<Pelicula> asignaturas=(ArrayList) asignatura;
        
        return asignaturas;
    }
    

public static Pelicula BuscarPelicula(String codigo) throws ErrorPelicula{
        Pelicula mipeli = new Pelicula();
        cn = new Conexion();
        try {
           
            rs = cn.st.executeQuery("SELECT * FROM pelicula WHERE idPelicula = '"+codigo+"';");
            while (rs.next()) {
                mipeli.setIdPelicula(rs.getString(1));
                mipeli.setPelicula(rs.getString(2));
                mipeli.setDuracion(rs.getString(3));
                mipeli.setEstreno(rs.getString(4));
                mipeli.setSinopsis(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        return mipeli;
    }
}


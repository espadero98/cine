/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorGenero.cn;
import static clases.ControladorPeliculaActor.cn;
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
public class ControladorPeliculaGenero {
    
    static Conexion cn;
    static ResultSet rs,rs2;

   
   
   
    public static void Agregar(String idPelicula,String idGenero) throws ErrorPelicula{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO peliculagenero(idPelicula,idGenero) VALUES('"+idPelicula+"','"+idGenero+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorPeliculaGenero/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(String idPelicula,String idGenero) throws ErrorPelicula{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE peliculagenero SET idPelicula='"+idPelicula+"',idGenero='"+idGenero+"' WHERE idPelicula='"+idPelicula+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorActor/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Actor peli) throws ErrorPelicula{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM actor WHERE idActor='"+peli.getIdActor()+"'");
        } catch (SQLException ex) {
            throw new ErrorPelicula("Class ControladorActor/Modificar",ex.getMessage());
        }
                
                
            
        
    }
    
    
    public static ArrayList<Actor> Buscar() throws ErrorPelicula{
        ArrayList<Object> actor = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT actor.idActor,actor.actor FROM actor");
            
                while (rs.next()) {
                    actor.add(rs.getString(1));
                    actor.add(rs.getString(2));
                   
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPelicula("Class ControladorActor/Buscar",e.getMessage());
        }
        
        ArrayList<Actor> actores=(ArrayList) actor;
        
        return actores;
    }
    
    public static Actor BuscarActor(String codigo) throws ErrorPelicula{
        Actor migenero = new Actor();
        String codigoPeli="";
        cn = new Conexion();
        try {
            rs2=cn.st.executeQuery("SELECT * FROM peliculaactor WHERE idPelicula = '"+codigo+"';");
           while (rs2.next()) {
                
                codigoPeli=rs2.getString(2);
                
            }
            rs = cn.st.executeQuery("SELECT * FROM actor WHERE idActor = '"+codigoPeli+"';");
            while (rs.next()) {
                migenero.setIdActor(rs.getString(1));
                migenero.setActor(rs.getString(2));
                
            }
        } catch (Exception e) {
        }
        return migenero;
    }
    
    public static ArrayList<Genero> BuscarActorPeliculas(String codigo) throws ErrorPelicula{
        ArrayList<Object> genero = new ArrayList<Object>();
        String codi="",codi2="";
        cn = new Conexion();
        try {
            
            rs = cn.st.executeQuery("SELECT * FROM peliculagenero WHERE idPelicula = '"+codigo+"';");
            while (rs.next()) {
                genero.add(rs.getString(1));
                genero.add(rs.getString(2));
                
            }
           
//            rs = cn.st.executeQuery("SELECT * FROM genero WHERE idGenero = '"+codi2+"';");
//            while (rs.next()) {
//                genero.add(rs.getString(1));
//                genero.add(rs.getString(2));
//                
//            }
        } catch (Exception e) {
        }
        ArrayList<Genero> generos=(ArrayList) genero;
        
        return generos;
    }
}


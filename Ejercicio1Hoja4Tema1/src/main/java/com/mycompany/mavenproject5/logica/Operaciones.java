/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5.logica;

import com.mycompany.mavenproject5.persistencia.ConexionMYSQL;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cancion;

/**
 *
 * @author salsa
 */
public class Operaciones {
    public Connection getConnection(){
        return ConexionMYSQL.getInstance().getConn();
    }
    public List<Cancion> mostrarCanciones(){
        List<Cancion> cancion=new ArrayList<>();
        String sql="Select numCancion,titulo,total_votos from canciones";
        try(Statement stmt=getConnection().createStatement();
                ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Cancion C1=CreaCanciones(rs);
                if(!cancion.add(C1)){
                    throw new Exception("No se añadio alguna cancion");
                }
                System.out.println("Se añadieron correctamnete");
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return cancion;
    }
    public void aumentarVotos(String titulo){
        String sql="Update canciones set total_votos=total_votos+1 where titulo=?";
       try(PreparedStatement pstmt=getConnection().prepareStatement(sql)){
           pstmt.setString(1, titulo);
           if(pstmt.executeUpdate()!=1){
               throw new Exception("No se añadio el voto");
           }
           System.out.println("Se añadio el voto correctamente");
       }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public  Cancion CreaCanciones(final ResultSet rs)throws SQLException{
        return new Cancion(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }
}

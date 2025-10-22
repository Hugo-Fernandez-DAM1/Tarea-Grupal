package logica;

import modelo.Voto;
import persistencia.ConexionMYSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    public static Connection getConnection(){
        return ConexionMYSQL.getInstance().getConn();
    }
    public static List<Voto> ultimosVotos(){
        List<Voto> votos=new ArrayList<>();
        String sql="SELECT usuario,fecha,cancion FROM votos ORDER BY fecha DESC LIMIT 10";
        try(Statement stmt=getConnection().createStatement();
        ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Voto V1=crearVoto(rs);
                votos.add(V1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return votos;
    }
    public static void modificarUsuario(String nombre,int id){
        String sql="Update usuario set nombre=? where id=?";
        try(PreparedStatement stmt=getConnection().prepareStatement(sql)){
        stmt.setString(1,nombre);
        stmt.setInt(2,id);
        if(stmt.executeUpdate()!=1){
            throw new Exception("Mal");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
   }
    public void eliminarVoto(String nombre){
        String sql="Delete usuarios where nombre=?";
        try(PreparedStatement stmt=getConnection().prepareStatement(sql)){
            stmt.setString(1,nombre);
            if(stmt.executeUpdate()!=1){
                throw new Exception("Mal");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static Voto crearVoto(final ResultSet rs)throws SQLException{
        return new Voto(rs.getString(1),rs.getDate(2).toLocalDate(),rs.getInt(3));
    }
}

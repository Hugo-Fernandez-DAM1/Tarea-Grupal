package es.edu.biblioteca.dao;

import es.edu.biblioteca.model.Autor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {
    private Connection getConnection(){
        return ConnectionManager.getInstance().getConnection();
    }
    public List<Autor> findAll() {
        String sql="Select id,nombre,nacionalidad from autores";
        List<Autor>autores=new ArrayList<Autor>();
        try(Statement stmt=getConnection().createStatement();
        ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Autor A1=crearAutor(rs);
                if(!autores.add(A1)){
                    throw new Exception("No se han guardado todos los usuarios");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return autores;
    }

    public void insert(Autor a) {
       String sql="Insert into autores(nombre,nacionalidad) values(?,?)";
      try(PreparedStatement pstmt=getConnection().prepareStatement(sql)){
          pstmt.setString(1,a.getNombre());
          pstmt.setString(2,a.getNacionalidad());
          if(pstmt.executeUpdate()!=1){
              throw new Exception("No se han guardado todos los usuarios");
          }
          System.out.println("Se inserto");
      }catch(SQLException ex){
          System.out.println(ex.getMessage());
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }

    public void update(Autor a,int nAutor) {
        String sql="Update autores set nombre=? , nacionalidad=? where id=?";
        try(PreparedStatement pstmt=getConnection().prepareStatement(sql)){
            pstmt.setString(1,a.getNombre());
            pstmt.setString(2,a.getNacionalidad());
            pstmt.setInt(3,nAutor);
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se actualizo a el usuario");
            }
            System.out.println("Se actualizo");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql="Delete from autores where id=?";
        try(PreparedStatement pstmt=getConnection().prepareStatement(sql)){
            pstmt.setInt(1,id);
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se ha eliminado a el usuario");
            }
            System.out.println("Se elimino");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Autor crearAutor(final ResultSet rs)throws SQLException{
        return new Autor(rs.getInt(1),rs.getString(2),rs.getString(3));
    }
}

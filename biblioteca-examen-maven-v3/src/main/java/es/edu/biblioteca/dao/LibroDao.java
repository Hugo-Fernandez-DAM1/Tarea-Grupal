package es.edu.biblioteca.dao;
import es.edu.biblioteca.model.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDao {
    private Connection getConnection(){
        return ConnectionManager.getInstance().getConnection();
    }
    public List<Libro> findAllWithAutor() {
        String sql="Select libros.id,titulo,idAutor,anioPublicacion,nombre from libros inner join autores on autores.id=idAutor";
        List<Libro>libros=new ArrayList<Libro>();
        try(Statement stmt=getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Libro L1=crearLibro(rs);
                if(!libros.add(L1)){
                    throw new Exception("No se han guardado todos los libros");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return libros;
    }

    public void insert(Libro l) {
        String sql="Insert into libros(titulo,idAutor,anioPublicacion) values(?,?,?)";
        try(PreparedStatement pstmt=getConnection().prepareStatement(sql)){
            pstmt.setString(1,l.getTitulo());
            pstmt.setInt(2,l.getIdAutor());
            pstmt.setInt(3,l.getAnioPublicacion());
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se han guardado todos los libros");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Libro crearLibro(final ResultSet rs)throws SQLException{
        return new Libro(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
    }
}

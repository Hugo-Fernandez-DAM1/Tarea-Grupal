package examen.dao;

import examen.model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDao implements Dao<Cliente> {
    private final Connection conn = ConnectionManager.getInstance().getConnection();

    @Override
    public Cliente findById(int id) {
        Cliente C1=null;
        String sql="Select id,nombre,email from clientes where id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            try(ResultSet rs=pstmt.executeQuery()){
                 C1=crearCliente(rs);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return C1;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes=new ArrayList<>();
        String sql="Select id,nombre,email from clientes";
        try(Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Cliente C1=crearCliente(rs);
                if(!clientes.add(C1)){
                    throw new Exception("Todos los clientes no se han guardado");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean insert(Cliente c) {
        boolean estaInsertado=false;
       String sql="Insert into clientes(nombre,email) values(?,?)";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,c.getNombre());
            pstmt.setString(2,c.getEmail());
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se guardo el cliente");
            }
            estaInsertado=true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       return estaInsertado;
    }

    @Override
    public boolean update(Cliente c) {
        boolean estaModificado=false;
        String sql="Update clientes set nombre=? , email=? where id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,c.getNombre());
            pstmt.setString(2,c.getEmail());
            pstmt.setInt(3,c.getId());
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se modifico el cliente");
            }
            estaModificado=true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estaModificado;
    }

    @Override
    public boolean delete(int id) {
        boolean estaEliminado=false;
        String sql="Delete from clientes inner join pedidos on clientes.id=cliente_id where clientes.id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se elimino el cliente");
            }
            estaEliminado=true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estaEliminado;
    }
    public static Cliente crearCliente(final ResultSet rs) throws SQLException{
      return new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3));
    }
}

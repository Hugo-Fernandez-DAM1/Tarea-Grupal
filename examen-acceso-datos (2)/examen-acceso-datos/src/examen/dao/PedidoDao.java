package examen.dao;

import examen.model.Cliente;
import examen.model.Pedido;
import java.sql.*;
import java.util.*;

public class PedidoDao implements Dao<Pedido> {
    private final Connection conn = ConnectionManager.getInstance().getConnection();

    @Override
    public Pedido findById(int id) {
        Pedido P1=null;
        String sql="Select id,cliente_id,fecha,importe from pedidos where id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            try(ResultSet rs=pstmt.executeQuery()){
                P1=crearPedido(rs);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return P1;
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos=new ArrayList<>();
        String sql="Select id,cliente_id,fecha,importe from pedidos";
        try(Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Pedido P1=crearPedido(rs);
                if(!pedidos.add(P1)){
                    throw new Exception("Todos los pedidos no se han guardado");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

    @Override
    public boolean insert(Pedido p) {
        boolean estaInsertado=false;
        String sql="Insert into pedidos(cliente_id,fecha,importe) values(?,?,?)";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,p.getClienteId());
            pstmt.setString(2,p.getFecha());
            pstmt.setDouble(3,p.getImporte());
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se guardo el pedido");
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
    public boolean update(Pedido p) {
        boolean estaModificado=false;
        String sql="Update pedidos set cliente_id=? , fecha=? , importe=? where id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,p.getClienteId());
            pstmt.setString(2,p.getFecha());
            pstmt.setDouble(3,p.getImporte());
            pstmt.setInt(4,p.getId());
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se modifico el pedido");
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
        String sql="Delete from pedidos where id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            if(pstmt.executeUpdate()!=1){
                throw new Exception("No se elimino el pedido");
            }
            estaEliminado=true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estaEliminado;
    }
    public static Pedido crearPedido(final ResultSet rs) throws SQLException{
        return new Pedido(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4));
    }
}

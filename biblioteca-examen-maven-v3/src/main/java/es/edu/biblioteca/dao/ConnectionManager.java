package es.edu.biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance;
    private Connection connection;

    private ConnectionManager() {
    String bd="jdbc:sqlite:librerias.db";
    try{
        connection=DriverManager.getConnection(bd);
        if(connection==null){
            System.out.println("No se conecto a la base de datos "+bd);
        }else{
            System.out.println("Se conecto a la base de datos "+bd);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        System.out.println(ex.getErrorCode());
        System.out.println(ex.getSQLState());
     }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) instance = new ConnectionManager();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    public boolean cerrar(){
        boolean estaCerrado=false;
        try{
            if(connection.isClosed()){
              connection.close();
              estaCerrado=true;
            }
        }catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }
        return estaCerrado;
    }
}

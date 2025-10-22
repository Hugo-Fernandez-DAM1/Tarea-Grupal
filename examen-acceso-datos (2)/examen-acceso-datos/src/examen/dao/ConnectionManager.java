package examen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance;
    private Connection connection;

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:examen.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    public boolean cerrar(){
        boolean sicerrado=false;
        try{
            if(!connection.isClosed()){
             connection.close();
             sicerrado=true;
            }
        }catch(SQLException ex){
        }
        return sicerrado;
    }
}

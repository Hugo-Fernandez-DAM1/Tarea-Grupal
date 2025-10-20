/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author salsa
 */
public class ConexionMYSQL {
     private static final String BD = "concursomusica";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "mysql";
    private static final String URL = "jdbc:mysql://localhost:3306/"+BD;
    private Connection conn = null;

    public ConexionMYSQL() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect","true");
            conn = DriverManager.getConnection(URL, properties);
            if (conn == null) {
                System.out.println("No se pudo conectar con: " + URL);
            } else {
                System.out.println("Conectado correctamnete a: " + URL);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getSQLState());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public static ConexionMYSQL getInstance() {
        return ConexionMYSQLHolder.INSTANCE;
    }

    private static class ConexionMYSQLHolder {
        private static final ConexionMYSQL INSTANCE = new ConexionMYSQL();
    }

    public boolean cerrar() {
        boolean cerrar = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                cerrar = true;
            }
        } catch (SQLException ex) {
            System.out.println("No se cerro la base de datos " + ex.getMessage());
        }
        return cerrar;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject5;

import com.mycompany.mavenproject5.app.Inicio;
import com.mycompany.mavenproject5.logica.Operaciones;
import com.mycompany.mavenproject5.persistencia.ConexionMYSQL;

/**
 *
 * @author salsa
 */
public class Mavenproject5 {

    public static void main(String[] args) {
        ConexionMYSQL conMYSQL=new ConexionMYSQL();
        Operaciones OP = new Operaciones();
        Inicio.eligeOpcion(OP,conMYSQL);
    }

}

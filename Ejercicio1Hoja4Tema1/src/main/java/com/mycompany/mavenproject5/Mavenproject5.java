/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject5;

import com.mycompany.mavenproject5.app.Inicio;
import com.mycompany.mavenproject5.logica.Operaciones;
import java.util.List;
import java.util.Scanner;
import model.Cancion;

/**
 *
 * @author salsa
 */
public class Mavenproject5 {

    public static void main(String[] args) {
        Operaciones OP = new Operaciones();
        Inicio.eligeOpcion(OP);
    }

}

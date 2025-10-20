/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5.app;

import com.mycompany.mavenproject5.logica.Operaciones;
import java.util.List;
import java.util.Scanner;
import model.Cancion;

/**
 *
 * @author salsa
 */
public class Inicio {

    public static int mostrarPresentacion() {
        System.out.println("Manejo Canciones");
        System.out.println("1- Mostrar Canciones");
        System.out.println("2- A\u00f1adir Voto");
        System.out.println("3- Salir");
        System.out.println("Introduce una opcion: ");
        int opcion = new Scanner(System.in).nextInt();
        return opcion;
    }

    public static void eligeOpcion(Operaciones OP) {
        int opcion;
        do {
            opcion = mostrarPresentacion();
            switch (opcion) {
                case 1 -> {
                    List<Cancion> canciones = OP.mostrarCanciones();
                    for (Cancion C1 : canciones) {
                        System.out.println(C1.toString());
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el nombre de la cancion");
                    String titulo = new Scanner(System.in).nextLine();
                    OP.aumentarVotos(titulo);
                }
                case 3 -> {
                    System.out.println("Saliendo del programa");
                }
                default -> {
                    System.out.println("Introduce una opcion valida");
                }
            }
        } while (opcion != 3);
    }
    
}

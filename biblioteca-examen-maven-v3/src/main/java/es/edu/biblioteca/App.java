package es.edu.biblioteca;

import es.edu.biblioteca.dao.ConnectionManager;
import es.edu.biblioteca.service.AutorService;
import es.edu.biblioteca.service.LibroService;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(ConnectionManager.getInstance().getConnection());
        AutorService autorSrv=new AutorService();
        LibroService libroSrv=new LibroService();
        int opcion;
        do {
            System.out.println("\n--- Gestor de Biblioteca ---");
            System.out.println("1. Listar autores");
            System.out.println("2. Añadir autor");
            System.out.println("3. Modificar autor");
            System.out.println("4. Eliminar autor");
            System.out.println("5. Listar libros (con autor)");
            System.out.println("6. Añadir libro");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> autorSrv.listarAutores();
                case 2 -> autorSrv.insertarAutor();
                case 3 -> autorSrv.actualizarAutor();
                case 4 -> autorSrv.eliminarAutor();
                case 5 -> libroSrv.listarLibrosConAutor();
                case 6 -> libroSrv.insertarLibro();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        ConnectionManager.getInstance().cerrar();
    }
}

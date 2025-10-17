package Presentacion;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FuncionesBD funcionesBD = new FuncionesBD();
        int opcion = 0;
        MenuOpciones();
    }

    private static void MenuOpciones() {
        int opcion;
        do {
            System.out.print("1. Mostrar canciones.\n" +
                    "2. Modificar número de votos.\n" +
                    "Introduce la opción deseada: ");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("¿Cuántas canciones quieres ver? ");
                    int numFilasCanciones = new Scanner(System.in).nextInt();
                    FuncionesBD.mostrarFilasCanciones(numFilasCanciones);
                }
                case 2 -> {
                    System.out.print("Introduce la canción que desea modificar sus votos: ");
                    String cancion = new Scanner(System.in).nextLine();
                    System.out.print("Introduce el número de votos que desea modificar: ");
                    int votosCancion = new Scanner(System.in).nextInt();
                    FuncionesBD.modificarVotos(cancion, votosCancion);
                }
                case 3 -> {
                    if (AccesoBD.getInstance().cerrarConexion()) {
                        System.out.println("Conexión cerrrada!");
                    } else {
                        System.out.println("La conexión no se cerró correctamente.");
                    }
                    System.out.println("Hasta luego!!");
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }
}
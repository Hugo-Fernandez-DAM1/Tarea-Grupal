import logica.Operaciones;
import persistencia.ConexionMYSQL;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        int opcion=new Scanner(System.in).nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.print("Nuevo nombre de usuario: ");
                String nuevoNombre = new Scanner(System.in).nextLine();
                System.out.print("Introduce su id: ");
                int id = new Scanner(System.in).nextInt();
                Operaciones.modificarUsuario(nuevoNombre, id);
                System.out.println("Usuario modificado correctamente.");
            }
            case 2 -> {
                System.out.println("El nombre de usuario que desea eliminarr: ");
                String eliminarNombre = new Scanner(System.in).nextLine();
                op.eliminarVoto(eliminarNombre);
                System.out.println("Voto eliminado correctamente.");
            }
            default -> System.out.println("Sin cambios.");
        }
        ConexionMYSQL.getInstance().cerrar();
    }
}
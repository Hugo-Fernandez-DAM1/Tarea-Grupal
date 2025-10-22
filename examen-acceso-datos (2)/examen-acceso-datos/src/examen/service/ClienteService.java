package examen.service;

import examen.dao.ClienteDao;
import examen.dao.ConnectionManager;
import examen.model.Cliente;
import java.util.*;

public class ClienteService {
    private final ClienteDao dao = new ClienteDao();
    private final Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de clientes ---");
            System.out.println("1. Listar");
            System.out.println("2. Insertar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Buscar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> listar();
                case 2 -> insertar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 5 -> buscar();
            }
        } while (opcion != 0);
        ConnectionManager.getInstance().cerrar();
    }

    private void listar() {
        List<Cliente> clientes=dao.findAll();
        for(Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
    }

    private void insertar() {
        System.out.println("Introduce tu nombre");
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Introduce tu email");
        String email=new Scanner(System.in).nextLine();
        Cliente C1=new Cliente(nombre,email);
        if(dao.insert(C1)){
            System.out.println("Se inserto el cliente");
        }
    }

    private void actualizar() {
        System.out.println("Introduce tu nuevo nombre");
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Introduce tu nuevo email");
        String email=new Scanner(System.in).nextLine();
        Cliente C1=new Cliente(nombre,email);
        if(dao.update(C1)){
            System.out.println("Se modifico el cliente correctamnete ");
        }
    }

    private void eliminar() {
        System.out.println("Introduce la id para eliminar");
        int id=new Scanner(System.in).nextInt();
        if(dao.delete(id)){
            System.out.println("Se elimino el cliente");
        }
    }
    public void buscar(){
        System.out.println("Introduce la id para verle");
        int id=new Scanner(System.in).nextInt();
        Cliente C1=dao.findById(id);
        C1.toString();
    }
}

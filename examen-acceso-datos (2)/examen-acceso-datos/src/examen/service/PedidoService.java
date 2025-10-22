package examen.service;

import examen.dao.ConnectionManager;
import examen.dao.PedidoDao;
import examen.model.Cliente;
import examen.model.Pedido;
import java.util.*;

public class PedidoService {
    private final PedidoDao dao = new PedidoDao();
    private final Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de pedidos ---");
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
        List<Pedido> pedidos=dao.findAll();
        for(Pedido pedido:pedidos){
            System.out.println(pedido.toString());
        }
    }

    private void insertar() {
        System.out.println("Introduce la id del usuario a insertar ese pedido");
     int id=new Scanner(System.in).nextInt();
        System.out.println("Introduce la fecha");
        String fecha=new Scanner(System.in).nextLine();
        System.out.println("Introduce el importe");
        double importe=new Scanner(System.in).nextDouble();
        Pedido P1=new Pedido(id,fecha,importe);
        if(dao.insert(P1)){
            System.out.println("Se inserto correctamnete");
        }
    }

    private void actualizar() {
        System.out.println("Introduce la nueva id del usuario a insertar ese pedido");
        int id=new Scanner(System.in).nextInt();
        System.out.println("Introduce nueva la fecha");
        String fecha=new Scanner(System.in).nextLine();
        System.out.println("Introduce el nuevo importe");
        double importe=new Scanner(System.in).nextDouble();
        Pedido P1=new Pedido(id,fecha,importe);
        if(dao.update(P1)){
            System.out.println("Se actualizo correctamnete");
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
        Pedido P1=dao.findById(id);
        P1.toString();
    }
}

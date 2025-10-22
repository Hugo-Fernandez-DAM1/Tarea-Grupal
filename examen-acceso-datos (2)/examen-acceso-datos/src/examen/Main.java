package examen;

import examen.service.ClienteService;
import examen.service.PedidoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar pedidos");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> clienteService.menu();
                case 2 -> pedidoService.menu();
            }
        } while (opcion != 0);
    }
}

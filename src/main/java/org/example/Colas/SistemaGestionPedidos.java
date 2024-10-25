package org.example.Colas;

import lombok.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


@AllArgsConstructor
@Data
@ToString

/**
 * Esta clase representa un sistema de gestión de pedidos.
 * @Autor Ana Lucelly Lizcano
 * Fecha: 25 de octubre del 2024
 * Licencia: GNU GPE
 */
public class SistemaGestionPedidos {
    @Getter
    private Queue<Pedido> colaPedidos;
    private Scanner scanner;

    public SistemaGestionPedidos() {
        colaPedidos = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Añade un nuevo pedido a la cola
     * @param nombreCliente Nombre del cliente que realiza el pedido
     */
    public void agregarPedido(String nombreCliente) {
        Pedido nuevoPedido = new Pedido(nombreCliente);
        colaPedidos.offer(nuevoPedido);
        System.out.println("\n El pedido se ha añadido bien!!✅");
        System.out.println(nuevoPedido);
    }

    /**
     * Procesa el siguiente pedido en la cola
     */
    public void procesarSigPedido() {
        if(colaPedidos.isEmpty()){
            System.out.println("\n No hay pedidos pendientes para procesar!!👀");
            return;
        }
        Pedido pedidoProcesado = colaPedidos.poll();
        System.out.println("\n Procesando el pedido...");
        System.out.println(pedidoProcesado);
    }

    /**
     * Muestra todos los pedidos en la cola.
     * Si no hay pedidos pendientes, muestra un mensaje de que no hay pedidos.
     */
    public void mostrarPedidosPendientes() {
        if(colaPedidos.isEmpty()) {
            System.out.println("\n No hay pedidos pendientes!!🫡");
            return;
        }
        System.out.println("\n ➡️Pedidos pendientes en la cola: ");
        int posicion = 1;
        for(Pedido pedido : colaPedidos){
            System.out.println(posicion + ". " + pedido);
            posicion++;
        }
    }

    /**
     * Muestra el menu de opciones
     */
    private void mostrarMenu() {
        System.out.println("\n~~ SISTEMA DE GESTIÓN DE PEDIDOS ~~");
        System.out.println("1. Agregar nuevo pedido");
        System.out.println("2. Procesar siguiente pedido");
        System.out.println("3. Ver pedidos pendientes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Ejecuta el menú principal del sistema.
     * Continúa ejecutando el menú hasta que el usuario seleccione la opción de salir.
     */
    public void ejecutarMenu() {
        int opc;
        do {
            mostrarMenu();
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("\n Ingresa el nombre del cliente: 👩🏽‍💻");
                    String nombreCliente = scanner.nextLine();
                    agregarPedido(nombreCliente);
                    break;
                case 2:
                    procesarSigPedido();
                    break;
                case 3:
                    mostrarPedidosPendientes();
                    break;
                case 4:
                    System.out.println("\n Saliendo del sistema...");
                    break;
                default:
                    System.out.println("\n Opción inválida. Intente nuevamente.");
            }
        }while (opc !=4);
    }

    //Metodo principal para ejecutar el programa
    public static void main(String[] args) {
        SistemaGestionPedidos sistema = new SistemaGestionPedidos();
        sistema.ejecutarMenu();
    }
}

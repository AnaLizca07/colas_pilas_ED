package org.example.Filas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.Stack;

@Data
@AllArgsConstructor


/**
 * Esta clase representa un historial de navegación en una pila.
 * Permite agregar y retroceder páginas web y mostrar el historial en orden.
 * @Autor Ana Lucelly Lizcano
 * Fecha: 25 de octubre del 2024
 * Licencia: GNU GPE
 */
public class HistorialNavegacion {
    private Stack<PaginaWeb> historial;
    private Scanner scanner;

    public HistorialNavegacion() {
        historial = new Stack<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Visita una nueva página web y la agrega al historial.
     *
     * @param url URL de la página a visitar.
     */
    public void visitarPagina(String url) {
        PaginaWeb nuevaPagina = new PaginaWeb(url);
        historial.push(nuevaPagina);
        System.out.println("\nEstás navegando a: " + nuevaPagina.getTitulo());
    }

    /**
     * Retrocede a la página anterior en el historial.
     */
    public void retroceder() {
        if (historial.size() <= 1) {
            System.out.println("\nNo hay páginas anteriores en el historial.");
            return;
        }

        PaginaWeb paginaActual = historial.pop();
        System.out.println("\nRetrocediendo desde la página: " + paginaActual.getTitulo());

        PaginaWeb paginaAnterior = historial.peek();
        System.out.println("Volviendo a: " + paginaAnterior.getTitulo());
    }

    /**
     * Muestra todo el historial de navegación en orden (más reciente primero).
     */
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("\nEl historial está vacío.");
            return;
        }

        System.out.println("\nHistorial de navegación (más reciente primero):");
        int contador = historial.size();
        for (int i = contador - 1; i >= 0; i--) {
            System.out.println((contador - i) + ". " + historial.get(i).getTitulo() + " - " + historial.get(i).getUrl());
        }
    }

    /**
     * Ejecuta el menú principal del sistema.
     */
    public void ejecutarMenu() {
        int opcion;
        do {
            mostrarMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese la URL a visitar: ");
                    String url = scanner.nextLine();
                    visitarPagina(url);
                    break;
                case 2:
                    retroceder();
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    System.out.println("\n¡Gracias por usar el navegador!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra el menú de opciones.
     */
    private void mostrarMenu() {
        System.out.println("\n=== NAVEGADOR WEB ===");
        System.out.println("1. Visitar nueva página");
        System.out.println("2. Retroceder");
        System.out.println("3. Ver historial");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Método principal para ejecutar el programa.
     */
    public static void main(String[] args) {
        HistorialNavegacion navegador = new HistorialNavegacion();
        System.out.println("¡Bienvenido al Navegador Web!");
        navegador.ejecutarMenu();
    }
}


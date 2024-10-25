package org.example.Colas;

import lombok.*;

@NoArgsConstructor
@Data
@ToString

/**
 * Esta clase representa un pedido de cliente.
 * @Autor Ana Lucelly Lizcano
 * Fecha: 25 de octubre del 2024
 * Licencia: GNU GPE
 */
public class Pedido {
    private String cliente;
    private int numeroOrden;
    private static int contadorOrdenes = 0;

    /**
     * Constructor personalizado que solo requiere al cliente.
     *
     * @param cliente El nombre del cliente que realiza el pedido.
     *                Este parámetro no puede ser nulo o vacío.
     */
    public Pedido(String cliente) {
        if (cliente == null || cliente.isEmpty()) {
            throw new IllegalArgumentException("Cliente no puede ser nulo o vacío");
        }
        this.cliente = cliente;
        this.numeroOrden = ++contadorOrdenes;
    }
}

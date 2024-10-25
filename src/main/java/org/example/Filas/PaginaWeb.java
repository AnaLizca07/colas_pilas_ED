package org.example.Filas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * Esta clase representa una página web en el navegador.
 * @Autor Ana Lucelly Lizcano
 * Fecha: 25 de octubre del 2024
 * Licencia: GNU GPE
 */
public class PaginaWeb {
    private String url;
    private String titulo;
    private long timestamp;

    /**
     * Constructor que inicializa una nueva instancia de la clase PaginaWeb con la URL proporcionada,
     * el título obtenido a partir de la URL y el timestamp actual.
     *
     * @param url La URL de la página web. No puede ser nula ni vacía.
     */
    public PaginaWeb(String url) {
        this.url = url;
        this.titulo = obtenerTituloPagina(url);
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Método privado que simplifica el título de la página web basado en la URL proporcionada.
     *
     * @param url La URL de la página web. No puede ser nula ni vacía.
     * @return El título simplificado de la página web.
     */
    private String obtenerTituloPagina(String url) {
        // Simplifica el título basado en la URL
        return url.replace("www.", "").replace(".com", "").replace(".org", "");
    }
}

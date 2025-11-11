package servicios;

import entidades.Libro;

public class LibroFactory {

    public static Libro crearLibro(String tipo, String titulo, String autor, int añoPublicacion, int copias) {
        if (tipo.equalsIgnoreCase("fisico")) {
            return new Libro(titulo, autor, añoPublicacion, copias);
        } else if (tipo.equalsIgnoreCase("digital")) {
            return new Libro(titulo + " (Digital)", autor, añoPublicacion, copias);
        } else {
            throw new IllegalArgumentException("Tipo de libro no reconocido: " + tipo);
        }
    }
}

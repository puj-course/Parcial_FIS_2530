package org.fis.grupo6;

public class Libro {
    public String titulo;
    public String autor;
    public String genero;
    public int anoPublicacion;
    public int numeroCopiasDisponibles;

    public void registrarLibro() {
        System.out.println("Libro " + titulo + " registrado");
    }

    public void actualizarCopiasDisponibles() {
        numeroCopiasDisponibles++;
        System.out.println("Número de copias actualizado");
    }
}

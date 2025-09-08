package org.fis.grupo6;

public class Usuario {
    public String nombre;
    public String apellido;
    public int cc;
    public String correo;
    public int telefono;
    public String tipo;

    public void solicitarPrestamo(Libro libro) {
        System.out.println("Solicita préstamo de " + libro.titulo);
    }
}

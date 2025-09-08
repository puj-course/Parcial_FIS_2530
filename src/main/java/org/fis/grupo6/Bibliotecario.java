package org.fis.grupo6;

public class Bibliotecario {
    public int idBibliotecario;

    public void registrarLibro(Libro libro) {
        System.out.println("Libro  " + libro.titulo + " registrado");
    }

    public void registrarDevolucion(Prestamo prestamo) {
        System.out.println("Devolución registrada  ");
    }

    public void verificarRetrasos() {
        System.out.println("No tiene retrasos");
    }
}

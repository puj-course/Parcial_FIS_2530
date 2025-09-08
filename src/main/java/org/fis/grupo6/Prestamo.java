package org.fis.grupo6;

import java.util.Date;

public class Prestamo {
    public Usuario usuario;
    public Libro libro;
    public Date fechaPrestamo;
    public Date fechaDevolucionEstimada;
    public String estado;

    public void registrarDevolucion() {
        System.out.println(libro.titulo + " devuelto");
    }

    public void verificarRetraso() {
        System.out.println("La devolución del libro no tiene retraso");
    }
}

package org.fis.grupo2.Patterns;

import puj.ads.Libro;
import com.example.usuaario.Usuario;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaFacade {
    private List<Libro> catalogoLibros;
    private List<Prestamo> prestamosActivos;
    private List<Usuario> usuariosRegistrados;

    public BibliotecaFacade() {
        this.catalogoLibros = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
        this.usuariosRegistrados = new ArrayList<>();
    }

    public void registrarNuevoLibro(String titulo, String autor, String genero, int anioPublicacion, int copias) {
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setGenero(genero);
        libro.setAnioPublicacion(anioPublicacion);
        libro.setNumeroCopiasDisponibles(copias);

        catalogoLibros.add(libro);
        libro.registrarLibro();
    }

    public void registrarNuevoUsuario(String nombre, String apellido, int cc, String correo, int telefono, String tipo) {
        Usuario usuario = new Usuario(nombre, apellido, cc, correo, telefono, tipo);
        usuariosRegistrados.add(usuario);
        System.out.println("Usuario registrado: " + nombre + " " + apellido);
    }

    public boolean realizarPrestamo(int ccUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuarioPorCC(ccUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return false;
        }

        if (libro == null) {
            System.out.println("Libro no encontrado");
            return false;
        }

        if (libro.getNumeroCopiasDisponibles() <= 0) {
            System.out.println("No hay copias disponibles");
            return false;
        }

        Date fechaPrestamo = new Date();
        Date fechaDevolucion = new Date(fechaPrestamo.getTime() + (15L * 24 * 60 * 60 * 1000));

        Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo, fechaDevolucion, "Activo");
        prestamosActivos.add(prestamo);

        libro.actualizarCopiasDisponibles(-1);

        System.out.println("Préstamo realizado exitosamente");
        System.out.println("Usuario: " + usuario.name + " " + usuario.apellido);
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Fecha devolución: " + fechaDevolucion);

        return true;
    }

    public boolean procesarDevolucion(int ccUsuario, String tituloLibro) {
        Prestamo prestamo = buscarPrestamoActivo(ccUsuario, tituloLibro);

        if (prestamo == null) {
            System.out.println("Préstamo no encontrado");
            return false;
        }

        prestamo.registrarDevolucion();
        prestamosActivos.remove(prestamo);
        prestamo.getLibro().actualizarCopiasDisponibles(1);

        return true;
    }

    public void verificarTodosLosRetrasos() {
        System.out.println("Verificando retrasos en préstamos...");
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getEstado().equals("Activo")) {
                prestamo.verificarRetraso();
            }
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("=== Estadísticas de la Biblioteca ===");
        System.out.println("Total de libros en catálogo: " + catalogoLibros.size());
        System.out.println("Total de usuarios registrados: " + usuariosRegistrados.size());
        System.out.println("Préstamos activos: " + prestamosActivos.size());

        int copiasDisponibles = 0;
        for (Libro libro : catalogoLibros) {
            copiasDisponibles += libro.getNumeroCopiasDisponibles();
        }
        System.out.println("Copias disponibles totales: " + copiasDisponibles);
    }

    private Usuario buscarUsuarioPorCC(int cc) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.cc == cc) {
                return usuario;
            }
        }
        return null;
    }

    private Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : catalogoLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private Prestamo buscarPrestamoActivo(int ccUsuario, String tituloLibro) {
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getUsuario().cc == ccUsuario &&
                    prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloLibro) &&
                    prestamo.getEstado().equals("Activo")) {
                return prestamo;
            }
        }
        return null;
    }
}
package org.fis.grupo2.Patterns;

import puj.ads.Libro;

public abstract class LibroDecorator extends Libro {
    protected Libro libroDecorado;

    public LibroDecorator(Libro libro) {
        this.libroDecorado = libro;
    }

    @Override
    public void registrarLibro() {
        libroDecorado.registrarLibro();
    }

    @Override
    public String getTitulo() {
        return libroDecorado.getTitulo();
    }
}

class LibroConCodigoBarras extends LibroDecorator {
    private String codigoBarras;

    public LibroConCodigoBarras(Libro libro, String codigoBarras) {
        super(libro);
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void registrarLibro() {
        super.registrarLibro();
        System.out.println("Código de barras asignado: " + codigoBarras);
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
}

class LibroConUbicacion extends LibroDecorator {
    private String estante;
    private String seccion;

    public LibroConUbicacion(Libro libro, String estante, String seccion) {
        super(libro);
        this.estante = estante;
        this.seccion = seccion;
    }

    @Override
    public void registrarLibro() {
        super.registrarLibro();
        System.out.println("Ubicación: Estante " + estante + ", Sección " + seccion);
    }

    public String getUbicacionCompleta() {
        return "Estante: " + estante + ", Sección: " + seccion;
    }
}

class LibroConEstadoConservacion extends LibroDecorator {
    private String estadoConservacion;

    public LibroConEstadoConservacion(Libro libro, String estadoConservacion) {
        super(libro);
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public void registrarLibro() {
        super.registrarLibro();
        System.out.println("Estado de conservación: " + estadoConservacion);
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }
}
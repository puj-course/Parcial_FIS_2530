package org.fis;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private int numeroCopiasDisponibles;

    // Constructor privado: solo se puede construir desde el Builder
    private Libro(Builder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.genero = builder.genero;
        this.anioPublicacion = builder.anioPublicacion;
        this.numeroCopiasDisponibles = builder.numeroCopiasDisponibles;
    }

    // Método para actualizar las copias
    public void actualizarCopiasDisponibles(int cantidad) {
        this.numeroCopiasDisponibles += cantidad;
    }

    // Builder interno estático
    public static class Builder {
        private String titulo;
        private String autor;
        private String genero;
        private int anioPublicacion;
        private int numeroCopiasDisponibles;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public Builder genero(String genero) {
            this.genero = genero;
            return this;
        }

        public Builder anioPublicacion(int anio) {
            this.anioPublicacion = anio;
            return this;
        }

        public Builder numeroCopiasDisponibles(int copias) {
            this.numeroCopiasDisponibles = copias;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }
    public String getTitulo() {
    return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getNumeroCopiasDisponibles() {
        return numeroCopiasDisponibles;
    }

}

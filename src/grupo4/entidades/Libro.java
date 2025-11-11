package entidades;

public class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private int numeroCopiasDisponibles;

    public Libro(String titulo, String autor, int añoPublicacion, int numeroCopiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
    }

    public void registrarLibro() {
        System.out.println("Libro registrado: " + titulo);
    }

    @Override
    public String toString() {
        return titulo + " de " + autor + " (" + añoPublicacion + ")";
    }
}

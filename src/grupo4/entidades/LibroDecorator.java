package entidades;

public abstract class LibroDecorator extends Libro {
    protected Libro libro;

    public LibroDecorator(Libro libro) {
        super(libro.getTitulo(), libro.getAutor(), libro.getAñoPublicacion(), libro.getNumeroCopiasDisponibles());
        this.libro = libro;
    }

    public abstract String getDescripcion();
}

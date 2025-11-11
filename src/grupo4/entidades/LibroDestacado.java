package entidades;

public class LibroDestacado extends LibroDecorator {

    public LibroDestacado(Libro libro) {
        super(libro);
    }

    @Override
    public String getDescripcion() {
        return libro.toString() + " 🌟 (Libro destacado)";
    }
}

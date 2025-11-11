public class Lector extends Usuario {
    public Lector() {
        this.tipo = "Lector";
    }

    @Override
    public void solicitarPrestamo(Libro libro) {
        System.out.println("El lector solicita un préstamo del libro: " + libro.getTitulo());
    }
}

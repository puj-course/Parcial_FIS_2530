package grupo3;

public class Factory {
    public static Libro crearLibro(String tipo) {
        if (tipo.equals("novela")) return new Libro("Don Quijote");
        else return new Libro("Enciclopedia");
    }
}

class Libro {
    String titulo;
    public Libro(String t) { this.titulo = t; }
    public void mostrar() { System.out.println("Libro creado: " + titulo); }
}

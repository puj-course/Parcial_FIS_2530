import entidades.Libro;
import servicios.LibroFactory;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = LibroFactory.crearLibro("fisico", "El Quijote", "Cervantes", 1605, 3);
        Libro libro2 = LibroFactory.crearLibro("digital", "1984", "Orwell", 1949, 10);

        System.out.println(libro1);
        System.out.println(libro2);
    }
}

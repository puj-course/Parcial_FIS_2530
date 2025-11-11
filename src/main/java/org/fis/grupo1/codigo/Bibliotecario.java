import java.util.*;
interface Observador{
    void actualizar(String mensaje);
}
public class Bibliotecario extends Usuario implements{
    public int idBibliotecario
    
    public ArrayList<Usuario> usuarios;
    public ArrayList<Libro> libros;
    
    public void actualizar(String mensaje) {
        System.out.println("Bibliotecario notificado: " + mensaje);
    }
    public void registrarLibro(Libro libro);
    public void verificarRetrasos();
    public void registrarDevolucion(Prestamo prestamo);
}
import java.util.*;
public class Prestamo{
    public Usuario usuario;
    public Libro libro;
    public Date fechaPrestamo;
    public date fechaDevolucionEstimanda;
    public String estado;
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Bibliotecario o) {
        observadores.add(o);
    }

    public void notificarRetraso() {
        for (Bibliotecario o : observadores) {
            o.actualizar("El préstamo tiene retraso.");
        }
    }
    
    public ArrayList<Libro> libros;
    
    
    public void registrarDevolucion();
    public void verificarRetraso();
}
import java.util.Date;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucionEstimada;
    private String estado;

    public Prestamo(Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucionEstimada, String estado) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.estado = estado;
    }

    public void registrarDevolucion() {
        this.estado = "Devuelto";
        System.out.println("Devolución registrada para el libro: " + libro.getTitulo());
    }

    public void verificarRetraso() {
        Date fechaActual = new Date();
        if (fechaActual.after(fechaDevolucionEstimada)) {
            System.out.println("El préstamo está en retraso.");
        } else {
            System.out.println("El préstamo está dentro del plazo.");
        }
    }

    // Getters y setters
    public Usuario getUsuario() {
        return usuario;
    }

   public void registrarDevolucion() {
    this.estado = "Devuelto";
    System.out.println("Devolución registrada para el libro: " + libro.getTitulo());
}


public Usuario getUsuario() { return usuario; }
public Libro   getLibro()   { return libro; }
public String  getEstado()  { return estado; }

}


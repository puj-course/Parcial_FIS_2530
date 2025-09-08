import java.util.Calendar;
import java.util.Date;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucionEstimada;
    private String estado;

    // Constructor privado: solo accesible desde la fábrica
    private Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = new Date();

        // Calculamos fecha estimada de devolución (por defecto 15 días)
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaPrestamo);
        cal.add(Calendar.DAY_OF_MONTH, 15);
        this.fechaDevolucionEstimada = cal.getTime();

        this.estado = "Activo";
    }

    // ✅ MÉTODO FACTORY INTERNO
    public static Prestamo crearPrestamo(Usuario usuario, Libro libro) {
        return new Prestamo(usuario, libro);
    }

    // Verifica si el préstamo está en retraso según la política del usuario
    public boolean verificarRetraso() {
        return usuario.tieneRetraso(fechaPrestamo, fechaDevolucionEstimada);
    }

    // Marca el préstamo como devuelto
    public void marcarComoDevuelto() {
        this.estado = "Devuelto";
    }

    // ===== Getters =====

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucionEstimada() {
        return fechaDevolucionEstimada;
    }

    public String getEstado() {
        return estado;
    }
}

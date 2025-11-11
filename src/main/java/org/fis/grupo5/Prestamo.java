import java.util.Calendar;
import java.util.Date;

public class Prestamo {
    public static Prestamo instancia;
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucionEstimada;
    private String estado;

    
    private Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaPrestamo);
        cal.add(Calendar.DAY_OF_MONTH, 15);
        this.fechaDevolucionEstimada = cal.getTime();

        this.estado = "Activo";
    } 
public Prestamo GetInstance(const std::string& value)
{
    if(instancia==nullptr){
        instancia = new Singleton(value);
    }
    return instancia;
}
    //Aquí se crea el constructor privado  - Para limitar la instancia del préstamo a una sola, que será única

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


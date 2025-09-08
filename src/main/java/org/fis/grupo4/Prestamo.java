import java.util.Date;

public class Prestamo {
    // Atributos
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucionEstimada;
    private String estado;
    
    // Constructor
    public Prestamo(Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucionEstimada, String estado) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.estado = estado;
    }
    
    // Getters y Setters
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Libro getLibro() {
        return libro;
    }
    
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public Date getFechaDevolucionEstimada() {
        return fechaDevolucionEstimada;
    }
    
    public void setFechaDevolucionEstimada(Date fechaDevolucionEstimada) {
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Métodos
    public void registrarDevolucion() {
        // Aquí irá la implementación de registrarDevolucion()
    }
    
    public void verificarRetraso() {
        // Aquí irá la implementación de verificarRetraso()
    }
} 
public class Usuario {
    // Atributos
    private String nombre;
    private String apellido;
    private Integer cc;
    private String correo;
    private Integer telefono;
    private String tipo;
    
    // Constructor
    public Usuario(String nombre, String apellido, Integer cc, String correo, Integer telefono, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cc = cc;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public Integer getCc() {
        return cc;
    }
    
    public void setCc(Integer cc) {
        this.cc = cc;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Integer getTelefono() {
        return telefono;
    }
    
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    // Métodos
    public void solicitarPrestamo(Libro libro) {
        // Aquí irá la implementación de solicitarPrestamo()
    }
} 
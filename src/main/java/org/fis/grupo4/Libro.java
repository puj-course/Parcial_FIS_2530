public class Libro {
    // Atributos
    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacion;
    private int numeroCopiasDisponibles;
    
    // Constructor
    public Libro(String titulo, String autor, String genero, int anoPublicacion, int numeroCopiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacion = anoPublicacion;
        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
    }
    
    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int getAnoPublicacion() {
        return anoPublicacion;
    }
    
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }
    
    public int getNumeroCopiasDisponibles() {
        return numeroCopiasDisponibles;
    }
    
    public void setNumeroCopiasDisponibles(int numeroCopiasDisponibles) {
        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
    }
    
    // Métodos
    public void registrarLibro() {
        // Aquí irá la implementación de registrarLibro()
    }
    
    public void actualizarCopiasDisponibles() {
        // Aquí irá la implementación de actualizarCopiasDisponibles()
    }
} 
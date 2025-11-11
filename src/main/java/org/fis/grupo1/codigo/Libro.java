public class Libro {

    private String titulo;
    private String autor;
    private String genero;
    private int añoPublicacion;

    public Libro(String titulo, String autor, String genero, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
    }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAñoPublicacion() { return añoPublicacion; }

    //clase para probar con @test
    public boolean esAntiguo() {
        return añoPublicacion < 2000;
    }
    public void registrarLibro();
    public void actualizarCopiasDisponibles();
}

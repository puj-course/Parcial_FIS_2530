package puj.ads;

public class Libro {

    String titulo;
    String autor;
    String genero;
    int anioPublicacion;
    int numeroCopiasDisponibles;

    public void registrarLibro (){
        System.out.println("Libro registrado: " + titulo);
    }
    public void actualizarCopiasDisponibles (int cantidad){
        this.numeroCopiasDisponibles += cantidad;
    }

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

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroCopiasDisponibles() {
        return numeroCopiasDisponibles;
    }

    public void setNumeroCopiasDisponibles(int numeroCopiasDisponibles) {
        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
    }
}

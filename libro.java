package prueba;

public class Libro {
	
	 public String titulo;
	    public String autor;
	    public String genero;
	    public int añoPublicacion;
	    public int numeroCopiasDisponibles;

	    public void libro(String titulo, String autor, String genero, int añoPublicacion, int numeroCopiasDisponibles) {
	        this.titulo = titulo;
	        this.autor = autor;
	        this.genero = genero;
	        this.añoPublicacion = añoPublicacion;
	        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
	    }

	    public void registrarLibro() {
	        
	    }

	    public void actualizarCopiasDisponibles(int cantidad) {
	       
	    }

}

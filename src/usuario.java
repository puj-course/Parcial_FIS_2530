class Usuario {
    public String nombre;
    public String apellido;
    public String cc;
    public int telefono;
    public String tipo;

    public Usuario(String nombre, String apellido, String cc, int telefono, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cc = cc;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public void solicitarPrestamo(Libro libro) {
        System.out.println(nombre + " ha solicitado el préstamo de " + libro);
    }

}
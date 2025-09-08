class Prestamo {
    public Usuario usuario;
    public Libro libro;
    public Date fechaPrestamo;
    public Date fechaDevolucionEstimada;
    public String estado;

    public Prestamo(Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucionEstimada, String estado) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.estado = estado;
    }

    public void registrarDevolucion() {
        System.out.println("Devolución registrada para el libro: " + libro);
    }

    public void verificarRetraso() {
    }
    }
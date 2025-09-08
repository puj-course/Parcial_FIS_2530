// ===================
// CLASE BIBLIOTECARIO
// ===================
class Bibliotecario {
    PrestamoFactory prestamoFactory;
    Notificador notificador;

    public Bibliotecario(PrestamoFactory factory, Notificador notificador) {
        this.prestamoFactory = factory;
        this.notificador = notificador;
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        if (libro.numeroCopiasDisponibles <= 0) {
            System.out.println("No hay copias disponibles");
            return null;
        }
        Prestamo prestamo = prestamoFactory.crearPrestamo(usuario, libro);
        libro.actualizarCopiasDisponibles(-1);
        notificador.enviarMensaje("Préstamo registrado para " + usuario.nombre);
        return prestamo;
    }

    public void registrarDevolucion(Prestamo prestamo, Libro libro) {
        libro.actualizarCopiasDisponibles(1);
        prestamo.estado = "Devuelto";
        if (prestamo.verificarRetraso()) {
            notificador.enviarMensaje("Usuario " + prestamo.usuario.nombre + " devolvió con retraso.");
        } else {
            notificador.enviarMensaje("Devolución exitosa de " + prestamo.usuario.nombre);
        }
    }
}

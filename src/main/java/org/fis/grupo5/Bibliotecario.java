// ===================
// CLASE BIBLIOTECARIO
// ===================
class Bibliotecario extends  Publisher  {
    PrestamoFactory prestamoFactory;
    Notificador notificador;
    // acaba iba un inicializador
    Admin admin = new Admin();
    this.suscribir(admin);

    public Bibliotecario(PrestamoFactory factory, Notificador notificador) {
        this.prestamoFactory = factory;
        this.notificador = notificador;
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        notificarSubs("libro registrado"+ libro); // se notifico del libro al admin 
        System.out.println("Suscrito admin: " + nombre + " - " + correo + " - " + telefono);
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

import java.util.Date;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        // Crear libro usando el patrón Builder
        Libro libro1 = new Libro.Builder()
            .titulo("Diseño de Software")
            .autor("Erich Gamma")
            .genero("Tecnología")
            .anioPublicacion(1994)
            .numeroCopiasDisponibles(3)
            .build();

        // Crear usuarios con diferentes políticas de retraso
        Usuario estudiante = new Usuario("Ana", new PoliticaEstudiante());
        Usuario profesor = new Usuario("Carlos", new PoliticaProfesor());

        // Crear gestor de usuario (mezcla notificador y estrategia si usas esa clase combinada)
        GestorUsuario gestor = new GestorUsuario();

        // Verificar que hay copias disponibles
        if (libro1.getNumeroCopiasDisponibles() > 0) {
            // Crear préstamo mediante método factory en Prestamo
            Prestamo prestamo = Prestamo.crearPrestamo(estudiante, libro1);
            libro1.actualizarCopiasDisponibles(-1);

            System.out.println("Préstamo realizado para: " + estudiante.getNombre());
            System.out.println("Fecha devolución estimada: " + prestamo.getFechaDevolucionEstimada());

            // Simular devolución
            libro1.actualizarCopiasDisponibles(1);
            prestamo.marcarComoDevuelto();

            // Verificar retraso
            if (prestamo.verificarRetraso()) {
                gestor.enviarNotificacion("email", "El usuario " + estudiante.getNombre() + " tiene un retraso.");
            } else {
                gestor.enviarNotificacion("sms", "Gracias por devolver el libro a tiempo.");
            }
        } else {
            System.out.println("No hay copias disponibles del libro.");
        }
    }
}

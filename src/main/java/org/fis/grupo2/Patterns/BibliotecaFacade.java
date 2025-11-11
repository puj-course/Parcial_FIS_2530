package org.fis.grupo2.Patterns;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class BibliotecaFacade {
    private List<Libro> catalogoLibros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public BibliotecaFacade() {
        this.catalogoLibros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // ===== OPERACIÓN COMPLEJA 1: REALIZAR PRÉSTAMO =====
    public boolean realizarPrestamo(Usuario usuario, Libro libro) {
        System.out.println("\n=== INICIANDO PROCESO DE PRÉSTAMO ===");

        // Paso 1: Verificar disponibilidad del libro
        if (!verificarDisponibilidadLibro(libro)) {
            System.out.println("❌ Préstamo rechazado: Libro no disponible");
            return false;
        }

        // Paso 2: Verificar límite de préstamos del usuario
        if (!verificarLimitePrestamos(usuario)) {
            System.out.println("❌ Préstamo rechazado: Usuario ha alcanzado el límite de préstamos");
            return false;
        }

        // Paso 3: Verificar que el usuario no tenga multas pendientes
        if (tieneMultasPendientes(usuario)) {
            System.out.println("❌ Préstamo rechazado: Usuario tiene multas pendientes");
            return false;
        }

        // Paso 4: Crear el préstamo
        Date fechaPrestamo = new Date();
        Date fechaDevolucion = calcularFechaDevolucion(fechaPrestamo, usuario.getDiasPrestamo());
        Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo, fechaDevolucion, "Activo");

        // Paso 5: Actualizar inventario
        libro.actualizarCopiasDisponibles(-1);

        // Paso 6: Registrar en el sistema
        prestamos.add(prestamo);
        usuario.agregarPrestamo(prestamo);

        // Paso 7: Enviar notificaciones
        enviarNotificacionPrestamo(usuario, libro, fechaDevolucion);

        System.out.println("✅ Préstamo realizado exitosamente");
        System.out.println("   Usuario: " + usuario.name + " " + usuario.apellido);
        System.out.println("   Libro: " + libro.getTitulo());
        System.out.println("   Fecha devolución: " + fechaDevolucion);
        return true;
    }

    // ===== OPERACIÓN COMPLEJA 2: REALIZAR DEVOLUCIÓN =====
    public boolean realizarDevolucion(Prestamo prestamo) {
        System.out.println("\n=== INICIANDO PROCESO DE DEVOLUCIÓN ===");

        // Paso 1: Verificar que el préstamo esté activo
        if (!"Activo".equals(prestamo.getEstado())) {
            System.out.println("❌ El préstamo ya fue devuelto");
            return false;
        }

        // Paso 2: Registrar la devolución
        prestamo.registrarDevolucion();

        // Paso 3: Actualizar inventario
        prestamo.getLibro().actualizarCopiasDisponibles(1);

        // Paso 4: Verificar si hay retraso y calcular multa
        if (hayRetraso(prestamo)) {
            int diasRetraso = prestamo.calcularDiasRetraso();
            double multa = calcularMultaPorRetraso(prestamo.getUsuario(), diasRetraso);
            System.out.println("⚠️  Devolución con retraso: " + diasRetraso + " días");
            System.out.println("   Multa aplicada: $" + multa);
            enviarNotificacionMulta(prestamo.getUsuario(), multa);
        }

        // Paso 5: Actualizar estado del usuario
        prestamo.getUsuario().removerPrestamo(prestamo);

        // Paso 6: Registrar en el sistema
        enviarNotificacionDevolucion(prestamo.getUsuario(), prestamo.getLibro());

        System.out.println("✅ Devolución procesada exitosamente");
        return true;
    }

    // ===== OPERACIÓN COMPLEJA 3: RENOVAR PRÉSTAMO =====
    public boolean renovarPrestamo(Prestamo prestamo) {
        System.out.println("\n=== INICIANDO RENOVACIÓN DE PRÉSTAMO ===");

        // Verificar que el préstamo esté activo
        if (!"Activo".equals(prestamo.getEstado())) {
            System.out.println("❌ No se puede renovar: préstamo no activo");
            return false;
        }

        // Verificar que no haya retraso
        if (hayRetraso(prestamo)) {
            System.out.println("❌ No se puede renovar: préstamo con retraso");
            return false;
        }

        // Verificar disponibilidad del libro
        if (prestamo.getLibro().getNumeroCopiasDisponibles() < 1) {
            System.out.println("❌ No se puede renovar: no hay copias disponibles");
            return false;
        }

        // Extender fecha de devolución
        Date nuevaFecha = calcularFechaDevolucion(
                prestamo.getFechaDevolucionEstimada(),
                prestamo.getUsuario().getDiasPrestamo()
        );

        System.out.println("✅ Préstamo renovado hasta: " + nuevaFecha);
        return true;
    }

    // ===== MÉTODOS PRIVADOS DE SOPORTE =====
    private boolean verificarDisponibilidadLibro(Libro libro) {
        return libro.getNumeroCopiasDisponibles() > 0;
    }

    private boolean verificarLimitePrestamos(Usuario usuario) {
        return usuario.cantidadPrestamosActivos() < usuario.getMaxPrestamos();
    }

    private boolean tieneMultasPendientes(Usuario usuario) {
        // Lógica para verificar multas pendientes
        return false; // Placeholder
    }

    private Date calcularFechaDevolucion(Date fechaInicio, int dias) {
        long milliseconds = fechaInicio.getTime() + (dias * 24L * 60 * 60 * 1000);
        return new Date(milliseconds);
    }

    private boolean hayRetraso(Prestamo prestamo) {
        Date fechaActual = new Date();
        return fechaActual.after(prestamo.getFechaDevolucionEstimada());
    }

    private double calcularMultaPorRetraso(Usuario usuario, int diasRetraso) {
        // Usar Strategy para calcular multa según tipo de usuario
        CalculadoraMulta calculadora = new CalculadoraMulta();

        switch (usuario.tipo.toLowerCase()) {
            case "estudiante":
                calculadora.setEstrategia(new MultaEstudiante());
                break;
            case "profesor":
                calculadora.setEstrategia(new MultaProfesor());
                break;
            case "administrativo":
                calculadora.setEstrategia(new MultaAdministrativo());
                break;
            case "invitado":
                calculadora.setEstrategia(new MultaInvitado());
                break;
        }

        return calculadora.calcular(diasRetraso);
    }

    private void enviarNotificacionPrestamo(Usuario usuario, Libro libro, Date fechaDevolucion) {
        System.out.println("📧 Notificación enviada a: " + usuario.correo);
        System.out.println("   Confirma préstamo del libro: " + libro.getTitulo());
    }

    private void enviarNotificacionDevolucion(Usuario usuario, Libro libro) {
        System.out.println("📧 Notificación de devolución enviada a: " + usuario.correo);
    }

    private void enviarNotificacionMulta(Usuario usuario, double multa) {
        System.out.println("📧 Notificación de multa enviada a: " + usuario.correo);
        System.out.println("   Monto: $" + multa);
    }

    // Getters para acceso controlado
    public List<Libro> getCatalogoLibros() {
        return catalogoLibros;
    }

    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
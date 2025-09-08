package org.fis.grupo2.BibliotecaFIS;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BibliotecarioTest {

    @Mock PrestamoFactory factory;
    @Mock Notificador notificador;
    @InjectMocks Bibliotecario bibliotecario;

    Usuario usuario;
    Libro libro;
    Prestamo prestamoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("Ana", "López", 123, "ana@mail.com", 3001234, "estudiante");
        libro = new Libro("ISBN-001", "Título", 2);

        // Creamos un prestamo simulado
        prestamoMock = mock(Prestamo.class);
    }

    @Test
    @DisplayName("1. registrarPrestamo: sin copias disponibles devuelve null")
    void testRegistrarPrestamoSinCopias() {
        libro.setNumeroCopiasDisponibles(0);

        // Capturamos salida estándar
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        Prestamo resultado = bibliotecario.registrarPrestamo(usuario, libro);

        assertNull(resultado);
        assertTrue(out.toString().contains("No hay copias disponibles"));
        verifyNoInteractions(factory, notificador);
    }

    @Test
    @DisplayName("2. registrarPrestamo: con copias crea préstamo y notifica")
    void testRegistrarPrestamoConCopias() {
        when(factory.crearPrestamo(usuario, libro)).thenReturn(prestamoMock);

        Prestamo resultado = bibliotecario.registrarPrestamo(usuario, libro);

        assertSame(prestamoMock, resultado);
        assertEquals(1, libro.getNumeroCopiasDisponibles());
        verify(factory).crearPrestamo(usuario, libro);
        verify(notificador).enviarMensaje("Préstamo registrado para " + usuario.getName());
    }

    @Test
    @DisplayName("3. registrarDevolución a tiempo actualiza, cambia estado y notifica éxito")
    void testRegistrarDevolucionATiempo() {
        when(prestamoMock.verificarRetraso()).thenReturn(false);
        bibliotecario.registrarDevolucion(prestamoMock, libro);

        assertEquals("Devuelto", prestamoMock.getEstado());
        assertEquals(3, libro.getNumeroCopiasDisponibles());
        verify(notificador).enviarMensaje("Devolución exitosa de " + usuario.getName());
    }

    @Test
    @DisplayName("4. registrarDevolución con retraso notifica retraso")
    void testRegistrarDevolucionConRetraso() {
        when(prestamoMock.verificarRetraso()).thenReturn(true);
        bibliotecario.registrarDevolucion(prestamoMock, libro);

        assertEquals("Devuelto", prestamoMock.getEstado());
        assertEquals(3, libro.getNumeroCopiasDisponibles());
        verify(notificador).enviarMensaje("Usuario " + usuario.getName() + " devolvió con retraso.");
    }

    @Test
    @DisplayName("5. registrarDevolución invoca métodos en orden correcto")
    void testRegistrarDevolucionOrdenLlamadas() {
        when(prestamoMock.verificarRetraso()).thenReturn(false);

        bibliotecario.registrarDevolucion(prestamoMock, libro);

        InOrder orden = inOrder(prestamoMock, notificador);
        // primero se fija el estado en Devuelto (campo), luego verifica retraso, luego notifica
        orden.verify(prestamoMock).verificarRetraso();
        orden.verify(notificador).enviarMensaje("Devolución exitosa de " + usuario.getName());
    }
}

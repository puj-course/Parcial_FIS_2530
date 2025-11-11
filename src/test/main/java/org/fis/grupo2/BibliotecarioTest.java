package org.fis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para Bibliotecario
 */
public class BibliotecarioTest {
    
    private Bibliotecario bibliotecario;
    private PrestamoFactory prestamoFactory;
    private Notificador notificador;
    private Usuario usuario;
    private Libro libro;
    
    @BeforeEach
    public void setUp() {
        // Crear mocks de las dependencias
        prestamoFactory = mock(PrestamoFactory.class);
        notificador = mock(Notificador.class);
        
        // Crear instancia de Bibliotecario
        bibliotecario = new Bibliotecario(prestamoFactory, notificador);
        
        // Crear objetos de prueba
        usuario = new Usuario();
        usuario.nombre = "Juan Pérez";
        
        libro = new Libro();
        libro.titulo = "El Quijote";
        libro.numeroCopiasDisponibles = 3;
    }
    
    @Test
    @DisplayName("Test: registrarPrestamo con copias disponibles")
    public void testRegistrarPrestamoExitoso() {
        // Configurar el mock para devolver un préstamo
        Prestamo prestamoEsperado = new Prestamo();
        when(prestamoFactory.crearPrestamo(usuario, libro)).thenReturn(prestamoEsperado);
        
        // Ejecutar el método
        Prestamo resultado = bibliotecario.registrarPrestamo(usuario, libro);
        
        // Verificaciones
        assertNotNull(resultado, "El préstamo no debería ser nulo");
        assertEquals(2, libro.numeroCopiasDisponibles, 
            "Las copias disponibles deberían reducirse en 1");
        verify(notificador).enviarMensaje("Préstamo registrado para " + usuario.nombre);
    }
    
    @Test
    @DisplayName("Test: registrarDevolucion sin retraso")
    public void testRegistrarDevolucionSinRetraso() {
        // Crear préstamo mock
        Prestamo prestamo = mock(Prestamo.class);
        prestamo.usuario = usuario;
        when(prestamo.verificarRetraso()).thenReturn(false);
        
        libro.numeroCopiasDisponibles = 2;
        
        // Ejecutar el método
        bibliotecario.registrarDevolucion(prestamo, libro);
        
        // Verificaciones
        assertEquals(3, libro.numeroCopiasDisponibles,
            "Las copias disponibles deberían aumentar en 1");
        verify(notificador).enviarMensaje("Devolución exitosa de " + usuario.nombre);
    }
}

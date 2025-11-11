package org.fis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Clase de pruebas unitarias para Administrador
 */
public class AdministradorTest {
    
    private Administrador administrador;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    public void setUp() {
        administrador = new Administrador();
        
        // Configurar captura de salida de consola para probar actualizar()
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("Test: Constructor inicializa el administrador correctamente")
    public void testConstructor() {
        assertNotNull(administrador, "El administrador no debería ser nulo");
    }
    
    @Test
    @DisplayName("Test: actualizar() imprime el mensaje correctamente")
    public void testActualizarMensaje() {
        String mensajePrueba = "Notificación de prueba";
        
        administrador.actualizar(mensajePrueba);
        
        String salida = outputStream.toString().trim();
        assertEquals(mensajePrueba, salida,
            "El mensaje impreso debería coincidir con el mensaje recibido");
    }
    
    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        // Restaurar la salida estándar original
        System.setOut(originalOut);
    }
}

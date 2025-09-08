package com.example.usuaario;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario u;
    private Libro dummyLibro;

    @BeforeEach
    void setUp() {
        u = new Usuario("Carlos", "Gómez", 12345678, "carlos@mail.com", 3001234567, "estudiante");
        dummyLibro = new Libro("ISBN-000", "Prueba");
    }

    @Test
    @DisplayName("1. Constructor asigna correctamente el nombre")
    void testNombre() {
        assertEquals("Carlos", u.name);
    }

    @Test
    @DisplayName("2. Constructor asigna correctamente el apellido")
    void testApellido() {
        assertEquals("Gómez", u.apellido);
    }

    @Test
    @DisplayName("3. Constructor asigna correctamente la cédula")
    void testCc() {
        assertEquals(12345678, u.cc);
    }

    @Test
    @DisplayName("4. Constructor asigna correctamente el correo")
    void testCorreo() {
        assertEquals("carlos@mail.com", u.correo);
    }

    @Test
    @DisplayName("5. solicitarPrestamo no lanza excepción")
    void testSolicitarPrestamo() {
        assertDoesNotThrow(() -> u.solicitarPrestamo(dummyLibro));
    }
}

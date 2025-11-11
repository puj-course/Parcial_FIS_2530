
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void testConstructorYGetters() {
        Libro libro = new Libro("1984", "George Orwell", "Distopía", 1949);

        assertEquals("1984", libro.getTitulo());
        assertEquals("George Orwell", libro.getAutor());
        assertEquals("Distopía", libro.getGenero());
        assertEquals(1949, libro.getAñoPublicacion());
    }

    @Test
    void testEsAntiguoVerdadero() {
        Libro libro = new Libro("Don Quijote", "Cervantes", "Novela", 1605);
        assertTrue(libro.esAntiguo());
    }

    @Test
    void testEsAntiguoFalso() {
        Libro libro = new Libro("El código Da Vinci", "Dan Brown", "Suspenso", 2003);
        assertFalse(libro.esAntiguo());
    }
}
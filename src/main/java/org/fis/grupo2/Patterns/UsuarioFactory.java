package org.fis.grupo2.Patterns;

interface UsuarioFactory {
    Usuario crearUsuario(String nombre, String apellido, int cc, String correo, int telefono);
}

class EstudianteFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(String nombre, String apellido, int cc, String correo, int telefono) {
        Usuario estudiante = new Usuario(nombre, apellido, cc, correo, telefono, "Estudiante");
        // Configuración específica para estudiantes
        estudiante.setMaxPrestamos(3);
        estudiante.setDiasPrestamo(15);
        return estudiante;
    }
}

class ProfesorFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(String nombre, String apellido, int cc, String correo, int telefono) {
        Usuario profesor = new Usuario(nombre, apellido, cc, correo, telefono, "Profesor");
        // Configuración específica para profesores
        profesor.setMaxPrestamos(10);
        profesor.setDiasPrestamo(30);
        return profesor;
    }
}

class FactoryProducer {
    public static UsuarioFactory getFactory(String tipoUsuario) {
        if (tipoUsuario.equalsIgnoreCase("Estudiante")) {
            return new EstudianteFactory();
        } else if (tipoUsuario.equalsIgnoreCase("Profesor")) {
            return new ProfesorFactory();
        }
        return null;
    }
}
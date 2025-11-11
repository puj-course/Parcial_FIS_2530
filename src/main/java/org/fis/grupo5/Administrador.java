package org.fis;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Administrador implements Suscribe {
    // Este archivo es solo un ejemplo. No lo modifiques.
    // Coloca tu código en un nuevo archivo java en tu propia carpeta de grupo dentro de /fis.
    private int idAdministrador;
    private GestorUsuario gestorUsuario; // Composición del gestor de usuarios


    public Administrador  () {
      idAdministrador = 1 ; // se quema el adminstrador
    this.gestorUsuario = new GestorUsuario(); // Instanciar el gestor
    }
     
    // Constructor que permite inyectar el gestor (para testing)
    public Administrador(GestorUsuario gestorUsuario) {
        this.idAdministrador = 1;
        this.gestorUsuario = gestorUsuario;
    }

    public void analizarDatos() {                //analiza los datos del sistemas
    }
    public void cantidadLibrosDisponibles() {            //devuelve un entero de la cantidad de libros disponibles para prestar
    }
    public int cantidadPrestamosActivos() {              //devuelve un entero de la cantidad de prestamos activos   
    }
    public int cantidadLibrosDevueltosUltimoMes() {        //devuelve un entero de la cantidad de libros devueltos el ultimo mes
    }
    public list<String> listarUsuariosConRetrasios() {    //devuelve una lista de los usuarios que estan enretraso
    }
    @Override
    public void actualizar(String mensaje) {
        // esto toco cambiarlo
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        mostrarMensaje();
    }
}
    public void verificarRetrasoUsuario(String tipoUsuario, Date fechaDevolucion) {
        boolean tieneRetraso = gestorUsuario.tieneRetraso(tipoUsuario, fechaDevolucion);
        System.out.println("El usuario " + tipoUsuario + " tiene retraso: " + tieneRetraso);
    }

    public void notificarUsuario(String tipoNotificacion, String mensaje) {
        gestorUsuario.enviarNotificacion(tipoNotificacion, mensaje);
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Administrador " + idAdministrador + " recibió: " + mensaje);
        // Podrías usar el gestor para notificar sobre esta actualización
        gestorUsuario.enviarNotificacion("email", "Actualización del sistema: " + mensaje);
    }

    public static void main(String[] args) {
        Administrador admin = new Administrador();
        
        // Ejemplo de uso del gestor de usuarios
        admin.verificarRetrasoUsuario("profesor", new Date());
        admin.notificarUsuario("email", "Recordatorio de devolución de libro");
        admin.actualizar("Nuevo libro disponible en el sistema");
    }
}

package org.fis;

public class Administrador implements Suscribe {
    // Este archivo es solo un ejemplo. No lo modifiques.
    // Coloca tu código en un nuevo archivo java en tu propia carpeta de grupo dentro de /fis.
    private int idAdministrador;


    public Administrador  () {
      idAdministrador = 1 ; // se quema el adminstrador
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

public class Admin {

    int idAdmin;

    public Admin (int idAdmin) {
        this.idAdmin= idAdmin;
    }

    private void analizarDatos() {
        //Realiza el proceso de analisis de datos del sistema para el administrador actual
    }

    private int cantidadLibrosDisponibles() {
        int numLibros = 0;
        //Devuelve la cantidad de libros disponibles en el sistema
        return numLibros;
    }

    private void listarUsuariosConRetraso (Usuario[] usuarios) {
        
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].tieneRetraso()) {
                System.out.println(usuarios[i].nombre);
            }
        }
    }

    private int cantidadPrestamosActivos (Usuario[] usuarios) {
        int numPrestamos = 0;
        for (int i = 0; i < usuarios.length; i++) {
            numPrestamos += usuarios[i].cantidadPrestamosActivos();
        }
        System.out.println(numPrestamos);
        return numPrestamos;
    }

    private int cantidadLibrosDevueltosUltimoMes (Usuario[] usuarios) {
        int numLibros = 0;
        for (int i = 0; i < usuarios.length; i++) {
            numLibros += usuarios[i].cantidadLibrosDevueltosUltimoMes();
        }
        System.out.println(numLibros);
        return numLibros;
    }


}

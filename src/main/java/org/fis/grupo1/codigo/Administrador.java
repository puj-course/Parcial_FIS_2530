class Administrador {
    private Administrador admin;
    public int idAdministrador;

    private Administrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    
    public static Administrador getAdmin(){
        if(admin==null){
            admin=new Administrador(0000000000);
        }
        return admin;
    }

    public void analizarDatos() {
        System.out.println("Datos actualizados por el administrador.");
    }

    public void cantidadLibrosDisponibles(List<Libro> libros) {

        System.out.println("Total de libros disponibles: "+total);
    }

    public void cantidadPrestamosActivos(List<Prestamo> prestamos) {
        System.out.println("Cantidad de préstamos activos: " +activos);
    }

    public void cantidadLibrosDevueltosUltimoMes(List<Prestamo> prestamos) {
        System.out.println("Cantidad de libros devueltos el último mes: " +devueltos);
    }

    public void listarUsuariosConRetrasos(List<Prestamo> prestamos) {
        
    }


}
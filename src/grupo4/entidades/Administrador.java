package entidades;

public class Administrador {
    private static Administrador instancia;
    private int idAdministrador;

    private Administrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public static Administrador getInstancia() {
        if (instancia == null) {
            instancia = new Administrador(1);
        }
        return instancia;
    }

    public void analizarDatos() {
        System.out.println("Analizando datos de préstamos y usuarios...");
    }
}

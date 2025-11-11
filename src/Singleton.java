package grupo3;

public class Singleton {
    private static Singleton instancia;

    private Singleton() { } // constructor privado

    public static Singleton getInstancia() {
        if (instancia == null) instancia = new Singleton();
        return instancia;
    }

    public void mostrar() {
        System.out.println("Patrón Singleton: misma instancia usada");
    }
}

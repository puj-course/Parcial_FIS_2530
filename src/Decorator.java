package grupo3;

interface Mensaje {
    void mostrar();
}

class MensajeSimple implements Mensaje {
    public void mostrar() { System.out.println("Mensaje base"); }
}

class DecoradorMayuscula implements Mensaje {
    private Mensaje mensaje;
    public DecoradorMayuscula(Mensaje m){ this.mensaje = m; }
    public void mostrar() {
        System.out.print("Patrón Decorator: ");
        mensaje.mostrar();
    }
}
package grupo3;

import java.util.ArrayList;
import java.util.List;

interface Observador {
    void actualizar(String mensaje);
}

public class Observer {
    private List<Observador> lista = new ArrayList<>();

    public void agregar(Observador o) { lista.add(o); }
    public void notificar(String mensaje) {
        for (Observador o : lista) o.actualizar(mensaje);
    }
}

// Ejemplo de observador concreto:
class Usuario implements Observador {
    String nombre;
    public Usuario(String n){ this.nombre = n; }
    public void actualizar(String msg){
        System.out.println(nombre + " recibió: " + msg);
    }
}

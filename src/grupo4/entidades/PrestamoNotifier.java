package servicios;

import java.util.ArrayList;
import java.util.List;

public class PrestamoNotifier implements Sujeto {
    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}

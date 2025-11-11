package servicios;

public interface Sujeto {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores(String mensaje);
}


package servicios;

public class NotificacionAdapter implements Notificador {
    private ServicioExternoNotificaciones servicio;

    public NotificacionAdapter(ServicioExternoNotificaciones servicio) {
        this.servicio = servicio;
    }

    @Override
    public void enviarNotificacion(String mensaje, String destinatario) {
        servicio.enviarMensaje(destinatario, mensaje);
    }
}

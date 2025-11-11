package org.fis.grupo2.Patterns;

public interface Notificacion {
    void enviar(String mensaje, String destinatario);
}

class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Email enviado a " + destinatario + ": " + mensaje);
    }
}

class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("SMS enviado a " + destinatario + ": " + mensaje);
    }
}

class NotificacionPush implements Notificacion {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Notificación push enviada a " + destinatario + ": " + mensaje);
    }
}

public class NotificacionFactory {
    public static Notificacion crearNotificacion(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new NotificacionEmail();
            case "sms":
                return new NotificacionSMS();
            case "push":
                return new NotificacionPush();
            default:
                throw new IllegalArgumentException("Tipo de notificación no válido: " + tipo);
        }
    }
}
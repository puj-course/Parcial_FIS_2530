public class GestorUsuario {

    // Lógica de política de retraso (tipo Strategy)
    public boolean tieneRetraso(String tipoUsuario, Date fechaDevolucionEstimada) {
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaDevolucionEstimada);

        switch (tipoUsuario.toLowerCase()) {
            case "profesor":
                cal.add(Calendar.DAY_OF_MONTH, 7); // profesores tienen 7 días extra
                break;
            case "estudiante":
            default:
                // sin cambios
                break;
        }

        return hoy.after(cal.getTime());
    }

    // Lógica de notificación (tipo Adapter simplificado)
    public void enviarNotificacion(String tipo, String mensaje) {
        switch (tipo.toLowerCase()) {
            case "email":
                enviarPorEmail(mensaje);
                break;
            case "sms":
                enviarPorSMS(mensaje);
                break;
            default:
                System.out.println("[Notificación] " + mensaje);
        }
    }

    private void enviarPorEmail(String mensaje) {
        System.out.println("[Email] " + mensaje);
    }

    private void enviarPorSMS(String mensaje) {
        System.out.println("[SMS] " + mensaje);
    }
}

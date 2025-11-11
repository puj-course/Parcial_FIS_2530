public class UsuarioFactory {
    public static Usuario crearUsuario(String tipo) {
        switch (tipo.toLowerCase()) {
            case "bibliotecario":
                return new Bibliotecario();
            case "lector":
                return new Lector();
            default:
                throw new IllegalArgumentException("Tipo de usuario desconocido: " + tipo);
        }
    }
}


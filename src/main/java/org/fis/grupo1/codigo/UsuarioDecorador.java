public abstract class UsuarioDecorator implements IUsuario {
    protected IUsuario usuarioDecorado;

    public UsuarioDecorator(IUsuario usuarioDecorado) {
        this.usuarioDecorado = usuarioDecorado;
    }

    @Override
    public void solicitarPrestamo(Libro libro) {
        usuarioDecorado.solicitarPrestamo(libro);
    }
}



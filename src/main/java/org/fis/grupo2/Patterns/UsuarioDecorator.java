package org.fis.grupo2.Patterns;

abstract class UsuarioDecorator extends Usuario {
    protected Usuario usuarioDecorado;

    public UsuarioDecorator(Usuario usuario) {
        super(usuario.name, usuario.apellido, usuario.cc, usuario.correo, usuario.telefono, usuario.tipo);
        this.usuarioDecorado = usuario;
        // Copiar configuración del usuario decorado
        this.setMaxPrestamos(usuario.getMaxPrestamos());
        this.setDiasPrestamo(usuario.getDiasPrestamo());
    }
}

// DECORADOR 1: Usuario con privilegios extendidos (más días de préstamo)
class UsuarioConPrivilegiosExtendidos extends UsuarioDecorator {
    private int diasAdicionales;

    public UsuarioConPrivilegiosExtendidos(Usuario usuario, int diasAdicionales) {
        super(usuario);
        this.diasAdicionales = diasAdicionales;
        System.out.println("🌟 Privilegio agregado: +" + diasAdicionales + " días de préstamo");
    }

    @Override
    public void solicitarPrestamo(Libro libro) {
        System.out.println("📚 Préstamo EXTENDIDO - Días adicionales: " + diasAdicionales);
        usuarioDecorado.solicitarPrestamo(libro);
    }

    @Override
    public int getDiasPrestamo() {
        return usuarioDecorado.getDiasPrestamo() + diasAdicionales;
    }

    public int getDiasAdicionales() {
        return diasAdicionales;
    }
}

// DECORADOR 2: Usuario con descuento en multas
class UsuarioConMultasReducidas extends UsuarioDecorator {
    private double porcentajeDescuento; // 0.0 a 1.0 (ej: 0.5 = 50% descuento)

    public UsuarioConMultasReducidas(Usuario usuario, double porcentajeDescuento) {
        super(usuario);
        this.porcentajeDescuento = porcentajeDescuento;
        System.out.println("💰 Beneficio agregado: " + (porcentajeDescuento * 100) + "% descuento en multas");
    }

    public double calcularMulta(double multaBase) {
        double multaConDescuento = multaBase * (1 - porcentajeDescuento);
        System.out.println("   Multa original: $" + multaBase);
        System.out.println("   Descuento aplicado: " + (porcentajeDescuento * 100) + "%");
        System.out.println("   Multa final: $" + multaConDescuento);
        return multaConDescuento;
    }
}

// DECORADOR 3: Usuario con más préstamos simultáneos
class UsuarioConMasPrestamos extends UsuarioDecorator {
    private int prestamosAdicionales;

    public UsuarioConMasPrestamos(Usuario usuario, int prestamosAdicionales) {
        super(usuario);
        this.prestamosAdicionales = prestamosAdicionales;
        System.out.println("📖 Beneficio agregado: +" + prestamosAdicionales + " préstamos simultáneos");
    }

    @Override
    public int getMaxPrestamos() {
        return usuarioDecorado.getMaxPrestamos() + prestamosAdicionales;
    }
}

// DECORADOR 4: Usuario con notificaciones premium
class UsuarioConNotificacionesPremium extends UsuarioDecorator {
    public UsuarioConNotificacionesPremium(Usuario usuario) {
        super(usuario);
        System.out.println("🔔 Beneficio agregado: Notificaciones Premium (Email + SMS + WhatsApp)");
    }

    @Override
    public void solicitarPrestamo(Libro libro) {
        usuarioDecorado.solicitarPrestamo(libro);
        enviarNotificacionPremium("Préstamo confirmado: " + libro.getTitulo());
    }

    private void enviarNotificacionPremium(String mensaje) {
        System.out.println("   📧 Email enviado");
        System.out.println("   📱 SMS enviado");
        System.out.println("   💬 WhatsApp enviado");
    }
}

class Usuario {
    String nombre;
    PoliticaRetraso politicaRetraso;

    public Usuario(String nombre, PoliticaRetraso politica) {
        this.nombre = nombre;
        this.politicaRetraso = politica;
    }

    public boolean tieneRetraso(Date fechaPrestamo, Date fechaDevolucionEstimada) {
        return politicaRetraso.tieneRetraso(fechaPrestamo, fechaDevolucionEstimada);
    }
}

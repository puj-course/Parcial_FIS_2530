package org.fis.grupo2.Patterns;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface EstrategiaMulta {
    double calcularMulta(long diasRetraso);
}

class MultaEstudiante implements EstrategiaMulta {
    @Override
    public double calcularMulta(long diasRetraso) {
        return diasRetraso * 500;
    }
}

class MultaProfesor implements EstrategiaMulta {
    @Override
    public double calcularMulta(long diasRetraso) {
        return diasRetraso * 1000;
    }
}

class MultaExterno implements EstrategiaMulta {
    @Override
    public double calcularMulta(long diasRetraso) {
        return diasRetraso * 2000;
    }
}

public class CalculadoraMulta {
    private EstrategiaMulta estrategia;

    public CalculadoraMulta(String tipoUsuario) {
        switch (tipoUsuario.toLowerCase()) {
            case "estudiante":
                this.estrategia = new MultaEstudiante();
                break;
            case "profesor":
                this.estrategia = new MultaProfesor();
                break;
            case "externo":
                this.estrategia = new MultaExterno();
                break;
            default:
                this.estrategia = new MultaEstudiante();
        }
    }

    public void setEstrategia(EstrategiaMulta estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularMultaPrestamo(Date fechaDevolucionEstimada, Date fechaDevolucionReal) {
        long diferenciaMilisegundos = fechaDevolucionReal.getTime() - fechaDevolucionEstimada.getTime();
        long diasRetraso = TimeUnit.MILLISECONDS.toDays(diferenciaMilisegundos);

        if (diasRetraso <= 0) {
            return 0;
        }

        return estrategia.calcularMulta(diasRetraso);
    }
}
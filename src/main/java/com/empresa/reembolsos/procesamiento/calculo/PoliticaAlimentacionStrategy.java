package com.empresa.reembolsos.procesamiento.calculo;

import com.empresa.reembolsos.dominio.SolicitudReembolso;

public class PoliticaAlimentacionStrategy implements PoliticaReembolsoStrategy {
    private static final double TOPE_DIARIO = 80000.0; // Tope $80,000 COP

    @Override
    public double calcularMontoReembolsable(SolicitudReembolso solicitud) {
        return Math.min(solicitud.getMontoOriginal(), TOPE_DIARIO);
    }
}

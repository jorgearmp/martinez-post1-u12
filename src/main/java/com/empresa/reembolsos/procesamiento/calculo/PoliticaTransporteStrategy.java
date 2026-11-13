package com.empresa.reembolsos.procesamiento.calculo;

import com.empresa.reembolsos.dominio.SolicitudReembolso;

public class PoliticaTransporteStrategy implements PoliticaReembolsoStrategy {
    @Override
    public double calcularMontoReembolsable(SolicitudReembolso solicitud) {
        // Transporte se reembolsa al 100% con soporte
        return solicitud.getMontoOriginal();
    }
}

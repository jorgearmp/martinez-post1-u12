package com.empresa.reembolsos.procesamiento.calculo;

import com.empresa.reembolsos.dominio.SolicitudReembolso;

public interface PoliticaReembolsoStrategy {
    double calcularMontoReembolsable(SolicitudReembolso solicitud);
}

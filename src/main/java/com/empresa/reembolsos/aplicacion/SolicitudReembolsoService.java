package com.empresa.reembolsos.aplicacion;

import com.empresa.reembolsos.dominio.CategoriaGasto;
import com.empresa.reembolsos.dominio.EstadoSolicitud;
import com.empresa.reembolsos.dominio.SolicitudReembolso;
import com.empresa.reembolsos.procesamiento.calculo.PoliticaAlimentacionStrategy;
import com.empresa.reembolsos.procesamiento.calculo.PoliticaReembolsoStrategy;
import com.empresa.reembolsos.procesamiento.calculo.PoliticaTransporteStrategy;
import com.empresa.reembolsos.procesamiento.notificacion.ObservadorReembolso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolicitudReembolsoService {
    private final Map<CategoriaGasto, PoliticaReembolsoStrategy> politicas = Map.of(
            CategoriaGasto.ALIMENTACION, new PoliticaAlimentacionStrategy(),
            CategoriaGasto.TRANSPORTE, new PoliticaTransporteStrategy()
    );

    private final List<ObservadorReembolso> observadores = new ArrayList<>();

    public void registrarObservador(ObservadorReembolso obs) {
        observadores.add(obs);
    }

    public SolicitudReembolso procesarAprobacion(SolicitudReembolso solicitud) {
        PoliticaReembolsoStrategy politica = politicas.getOrDefault(
                solicitud.getCategoria(), s -> s.getMontoOriginal()
        );

        double montoFinal = politica.calcularMontoReembolsable(solicitud);
        solicitud.setMontoAprobado(montoFinal);
        solicitud.setEstado(EstadoSolicitud.APROBADA);

        String msg = String.format("Solicitud %s aprobada por $%.2f (Original: $%.2f)",
                solicitud.getId(), montoFinal, solicitud.getMontoOriginal());
        observadores.forEach(obs -> obs.notificarEvento(solicitud, msg));

        return solicitud;
    }
}

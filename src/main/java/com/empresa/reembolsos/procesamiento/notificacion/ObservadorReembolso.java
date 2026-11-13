package com.empresa.reembolsos.procesamiento.notificacion;

import com.empresa.reembolsos.dominio.SolicitudReembolso;

public interface ObservadorReembolso {
    void notificarEvento(SolicitudReembolso solicitud, String mensaje);
}

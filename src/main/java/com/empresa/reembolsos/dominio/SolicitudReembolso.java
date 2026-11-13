package com.empresa.reembolsos.dominio;

import java.time.LocalDate;

public class SolicitudReembolso {
    private final String id;
    private final String empleado;
    private final CategoriaGasto categoria;
    private final double montoOriginal;
    private double montoAprobado;
    private final LocalDate fechaGasto;
    private EstadoSolicitud estado;

    public SolicitudReembolso(String id, String empleado, CategoriaGasto categoria, double montoOriginal, LocalDate fechaGasto) {
        this.id = id;
        this.empleado = empleado;
        this.categoria = categoria;
        this.montoOriginal = montoOriginal;
        this.montoAprobado = montoOriginal;
        this.fechaGasto = fechaGasto;
        this.estado = EstadoSolicitud.ENVIADA;
    }

    public String getId() { return id; }
    public String getEmpleado() { return empleado; }
    public CategoriaGasto getCategoria() { return categoria; }
    public double getMontoOriginal() { return montoOriginal; }
    public double getMontoAprobado() { return montoAprobado; }
    public void setMontoAprobado(double montoAprobado) { this.montoAprobado = montoAprobado; }
    public LocalDate getFechaGasto() { return fechaGasto; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
}

package com.empresa.reembolsos;

import com.empresa.reembolsos.aplicacion.SolicitudReembolsoService;
import com.empresa.reembolsos.dominio.CategoriaGasto;
import com.empresa.reembolsos.dominio.SolicitudReembolso;

import java.time.LocalDate;

public class ReembolsosApplication {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" PROYECTO INTEGRADOR: REEMBOLSOS CORPORATIVOS - UNIDAD 12 (UFPS)");
        System.out.println(" Estudiante: Jorge Martínez");
        System.out.println("==================================================================");

        var service = new SolicitudReembolsoService();

        // Registrar observador de auditoría
        service.registrarObservador((sol, msg) ->
                System.out.println("  [EVENTO AUDITORÍA / EMAIL]: " + msg));

        // Solicitud 1: Alimentación excediendo tope de $80,000 COP
        var sol1 = new SolicitudReembolso("REM-001", "Jorge Martínez", CategoriaGasto.ALIMENTACION, 125000.0, LocalDate.now());
        System.out.println("Procesando solicitud de alimentación por $125,000...");
        service.procesarAprobacion(sol1);
        System.out.printf("Resultado 1: Aprobado $%.2f (Tope legal aplicado con Strategy)%n%n", sol1.getMontoAprobado());

        // Solicitud 2: Transporte
        var sol2 = new SolicitudReembolso("REM-002", "Jorge Martínez", CategoriaGasto.TRANSPORTE, 45000.0, LocalDate.now());
        System.out.println("Procesando solicitud de transporte por $45,000...");
        service.procesarAprobacion(sol2);
        System.out.printf("Resultado 2: Aprobado $%.2f (100%% reembolsado)%n%n", sol2.getMontoAprobado());

        System.out.println("Proyecto Integrador finalizado con 100% de cumplimiento.");
    }
}

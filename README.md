# ACTIVIDAD POST-CONTENIDO — UNIDAD 12
## PROYECTO INTEGRADOR: SISTEMA DE REEMBOLSOS DE GASTOS CORPORATIVOS
**Estudiante:** Jorge Armando Martínez Peinado (Cód. 1152162)  
**Curso:** Patrones de Diseño de Software (1156701-A)  
**Institución:** Universidad Francisco de Paula Santander (UFPS)  

---

## ESTRUCTURA DEL PROYECTO
```text
martinez-post1-u12/
├── docs/
│   └── adr/
│       └── ADR-001.md
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/empresa/reembolsos/
                ├── ReembolsosApplication.java
                ├── aplicacion/
                │   └── SolicitudReembolsoService.java
                ├── dominio/
                │   ├── CategoriaGasto.java
                │   ├── EstadoSolicitud.java
                │   └── SolicitudReembolso.java
                └── procesamiento/
                    ├── calculo/
                    │   ├── PoliticaAlimentacionStrategy.java
                    │   ├── PoliticaReembolsoStrategy.java
                    │   └── PoliticaTransporteStrategy.java
                    └── notificacion/
                        └── ObservadorReembolso.java
```

---

## INSTRUCCIONES DE EJECUCIÓN
```bash
mvn clean compile
mvn exec:java
```

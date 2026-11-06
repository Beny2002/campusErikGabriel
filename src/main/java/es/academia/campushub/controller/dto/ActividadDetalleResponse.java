package es.academia.campushub.controller.dto;

import java.util.List;

public record ActividadDetalleResponse(
    ActividadResponse actividad,
    DocenteResponse responsable,
    Integer plazasOcupadas,
    Integer plazasDisponibles,
    List<EstudianteResponse> estudiantes,
    List<EtiquetaResponse> etiquetas,
    List<SeguimientoResponse> seguimientos) {}

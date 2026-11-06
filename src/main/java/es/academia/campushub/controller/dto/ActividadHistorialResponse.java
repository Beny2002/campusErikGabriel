package es.academia.campushub.controller.dto;

public record ActividadHistorialResponse(
    Long id,
    String titulo,
    String tipo,
    String fechaPrevista,
    String fechaInscripcion,
    DocenteResponse responsable) {}

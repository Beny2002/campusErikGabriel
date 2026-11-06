package es.academia.campushub.controller.dto;

public record ActividadResponse(
    Long id,
    String titulo,
    String descripcion,
    String tipo,
    String fechaPrevista,
    Integer maxParticipantes,
    Long docenteId) {}

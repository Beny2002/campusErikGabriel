package es.academia.campushub.controller.dto;

public record CreateActividadRequest(
    String titulo,
    String descripcion,
    String tipo,
    String fechaPrevista,
    Integer maxParticipantes,
    Long docenteId) {}

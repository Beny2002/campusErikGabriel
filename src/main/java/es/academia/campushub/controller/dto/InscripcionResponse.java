package es.academia.campushub.controller.dto;

public record InscripcionResponse(
    Long id, Long actividadId, Long estudianteId, String fechaInscripcion) {}

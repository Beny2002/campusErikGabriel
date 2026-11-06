package es.academia.campushub.controller.dto;

public record ContactoResponse(
    Long estudianteId,
    String tutorLegal,
    String telefono,
    String email,
    Boolean autorizado,
    String fechaAutorizacion) {}

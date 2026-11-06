package es.academia.campushub.controller.dto;

public record UpsertContactoRequest(
    String tutorLegal,
    String telefono,
    String email,
    Boolean autorizado,
    String fechaAutorizacion) {}

package es.academia.campushub.controller.dto;

public record DocenteResponse(
    Long id, String nombre, String apellidos, String email, Long departamentoId) {}

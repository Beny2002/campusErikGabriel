package es.academia.campushub.controller.dto;

public record CreateDocenteRequest(
    String nombre, String apellidos, String email, Long departamentoId) {}

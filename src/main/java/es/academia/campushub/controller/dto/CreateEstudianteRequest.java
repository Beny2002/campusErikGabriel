package es.academia.campushub.controller.dto;

public record CreateEstudianteRequest(
    String nombre, String apellidos, String email, String fechaNacimiento, Long grupoId) {}

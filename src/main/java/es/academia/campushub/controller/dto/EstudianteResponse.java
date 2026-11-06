package es.academia.campushub.controller.dto;

public record EstudianteResponse(
    Long id, String nombre, String apellidos, String email, String fechaNacimiento, Long grupoId) {}

package es.academia.campushub.controller.dto;

import java.util.Map;

public record CreateSeguimientoRequest(String tipo, Map<String, Object> datos) {}

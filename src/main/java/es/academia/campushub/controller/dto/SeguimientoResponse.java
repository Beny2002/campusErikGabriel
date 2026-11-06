package es.academia.campushub.controller.dto;

import java.util.Map;

public record SeguimientoResponse(
    String id, Long actividadId, String tipo, Map<String, Object> datos, String creadoEn) {}

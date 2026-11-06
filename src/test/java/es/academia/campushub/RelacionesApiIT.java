package es.academia.campushub;

import static org.junit.jupiter.api.Assertions.assertTrue;

import es.academia.campushub.support.ApiIntegrationSupport;
import org.junit.jupiter.api.Test;

/** Pruebas visibles de relaciones e integridad de la API. */
class RelacionesApiIT extends ApiIntegrationSupport {
  @Test
  void inscripcionUnicaYAforo() throws Exception {
    long dept = id(post("/api/departamentos", "{\"nombre\":\"DepartamentoUno\"}"));
    long docente =
        id(
            post(
                "/api/docentes",
                "{\"nombre\":\"Rosa\",\"apellidos\":\"Gómez\",\"email\":\"rosa.inscripciones@test.invalid\",\"departamentoId\":"
                    + dept
                    + "}"));
    long grupo =
        id(
            post(
                "/api/grupos",
                "{\"nombre\":\"DAM1-A\",\"nivel\":\"1 DAM\",\"tutorDocenteId\":" + docente + "}"));
    long e1 =
        id(
            post(
                "/api/estudiantes",
                "{\"nombre\":\"Eva\",\"apellidos\":\"Uno\",\"email\":\"eva1@test.invalid\",\"fechaNacimiento\":\"2005-01-01\",\"grupoId\":"
                    + grupo
                    + "}"));
    long e2 =
        id(
            post(
                "/api/estudiantes",
                "{\"nombre\":\"Eva\",\"apellidos\":\"Dos\",\"email\":\"eva2@test.invalid\",\"fechaNacimiento\":\"2005-01-02\",\"grupoId\":"
                    + grupo
                    + "}"));
    long actividad =
        id(
            post(
                "/api/actividades",
                "{\"titulo\":\"Laboratorio\",\"descripcion\":\"Práctica\",\"tipo\":\"TALLER\",\"fechaPrevista\":\"2027-07-01\",\"maxParticipantes\":1,\"docenteId\":"
                    + docente
                    + "}"));
    status(
        201,
        post("/api/actividades/" + actividad + "/inscripciones", "{\"estudianteId\":" + e1 + "}"));
    status(
        409,
        post("/api/actividades/" + actividad + "/inscripciones", "{\"estudianteId\":" + e1 + "}"));
    status(
        409,
        post("/api/actividades/" + actividad + "/inscripciones", "{\"estudianteId\":" + e2 + "}"));
    var detalle = get("/api/actividades/" + actividad + "/detalle");
    status(200, detalle);
    assertTrue(detalle.body().contains("\"plazasDisponibles\":0"), detalle.body());
    status(200, get("/api/estudiantes/" + e1 + "/actividades"));
  }

  @Test
  void fichaYRelacionDeEtiquetas() throws Exception {
    long dept = id(post("/api/departamentos", "{\"nombre\":\"DepartamentoDos\"}"));
    long docente =
        id(
            post(
                "/api/docentes",
                "{\"nombre\":\"Carlos\",\"apellidos\":\"López\",\"email\":\"carlos.contacto@test.invalid\",\"departamentoId\":"
                    + dept
                    + "}"));
    long grupo =
        id(
            post(
                "/api/grupos",
                "{\"nombre\":\"DAM2-B\",\"nivel\":\"2 DAM\",\"tutorDocenteId\":" + docente + "}"));
    long estudiante =
        id(
            post(
                "/api/estudiantes",
                "{\"nombre\":\"Lola\",\"apellidos\":\"Ortiz\",\"email\":\"lola@test.invalid\",\"fechaNacimiento\":\"2004-01-01\",\"grupoId\":"
                    + grupo
                    + "}"));
    status(
        200,
        put(
            "/api/estudiantes/" + estudiante + "/contacto",
            "{\"tutorLegal\":\"Julia Ortiz\",\"telefono\":\"600000000\",\"email\":\"julia@test.invalid\",\"autorizado\":true,\"fechaAutorizacion\":\"2026-10-01\"}"));
    var contacto = get("/api/estudiantes/" + estudiante + "/contacto");
    status(200, contacto);
    assertTrue(contacto.body().contains("Julia Ortiz"));
    long actividad =
        id(
            post(
                "/api/actividades",
                "{\"titulo\":\"Seguridad\",\"descripcion\":\"Charla\",\"tipo\":\"CHARLA\",\"fechaPrevista\":\"2027-06-01\",\"maxParticipantes\":10,\"docenteId\":"
                    + docente
                    + "}"));
    long etiqueta = id(post("/api/etiquetas", "{\"nombre\":\"seguridad-prueba-publica\"}"));
    status(204, put("/api/actividades/" + actividad + "/etiquetas/" + etiqueta, null));
    var lista = get("/api/etiquetas/" + etiqueta + "/actividades");
    status(200, lista);
    assertTrue(lista.body().contains("Seguridad"), lista.body());
  }
}

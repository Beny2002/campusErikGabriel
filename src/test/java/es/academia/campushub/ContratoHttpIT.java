package es.academia.campushub;

import es.academia.campushub.support.ApiIntegrationSupport;
import org.junit.jupiter.api.Test;

class ContratoHttpIT extends ApiIntegrationSupport {
  @Test
  void jsonMalformadoEs400() throws Exception {
    status(400, post("/api/estudiantes", "{"));
  }

  @Test
  void recursoInexistenteEs404() throws Exception {
    status(404, get("/api/actividades/99999999"));
  }
}

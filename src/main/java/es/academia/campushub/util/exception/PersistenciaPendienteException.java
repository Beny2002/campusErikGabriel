package es.academia.campushub.util.exception;

public class PersistenciaPendienteException extends RuntimeException {
  public PersistenciaPendienteException(String operacion) {
    super("Falta implementar persistencia: " + operacion);
  }
}

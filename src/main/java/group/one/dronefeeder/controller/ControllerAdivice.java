package group.one.dronefeeder.controller;

import group.one.dronefeeder.exception.DataError;
import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class ControllerAdivice.
 */
@ControllerAdvice
public class ControllerAdivice {
  @ExceptionHandler({DroneExistenteException.class})
  public ResponseEntity<DataError> handleConflict(RuntimeException err) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(new DataError(err.getMessage()));
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<DataError> handleNotFound(RuntimeException err) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataError(err.getMessage()));
  }
}

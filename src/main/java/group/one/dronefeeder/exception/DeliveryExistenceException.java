package group.one.dronefeeder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public class DeliveryExistenceException extends RuntimeException {
  public DeliveryExistenceException() {
    super("Delivery Already Exist");
  }

}

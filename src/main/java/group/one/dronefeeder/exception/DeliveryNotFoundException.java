package group.one.dronefeeder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeliveryNotFoundException extends RuntimeException {

  public DeliveryNotFoundException() {
    super("Delivery Not Found");
  }

}

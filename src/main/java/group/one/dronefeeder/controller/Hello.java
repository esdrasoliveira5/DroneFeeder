package group.one.dronefeeder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello.
 */
@RestController
public class Hello {
  @GetMapping
  public String findAll() {
    return "Hello World - Drone Feeder";
  }
}

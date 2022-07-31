package group.one.dronefeeder.controller;

import group.one.dronefeeder.service.DroneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import group.one.dronefeeder.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * DroneController.
 */
@RestController
public class DroneController {
  @Autowired
  private DroneService service;

  @GetMapping("/")
  public String testApplication() {
    return "Teste";
  }

  @PostMapping("/droneteste")
  public Drone testDrone(@RequestBody Drone drone) {
    return drone;
  }

  @PostMapping("/drone")
  public Drone create(@RequestBody Drone drone) {
    return service.create(drone);
  }

  @GetMapping("/drone")
  public List<Drone> all() {
    return service.findAll();
  }
}

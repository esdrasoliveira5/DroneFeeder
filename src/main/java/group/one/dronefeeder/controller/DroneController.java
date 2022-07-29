package group.one.dronefeeder.controller;

import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * DroneController.
 */
@RestController
public class DroneController {
  @Autowired
  private DroneService service;

  @GetMapping("/drone")
  public Drone create(@RequestBody Drone drone) {
    return service.create(drone);
  }

}

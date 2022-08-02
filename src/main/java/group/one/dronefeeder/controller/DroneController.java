package group.one.dronefeeder.controller;

import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.repository.DroneRepository;
import group.one.dronefeeder.service.DroneService;
import org.springframework.web.bind.annotation.*;
import group.one.dronefeeder.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

/**
 * DroneController.
 */
@RestController
@RequestMapping("/dronefeeder")
public class DroneController {
  @Autowired
  private DroneService droneService;

  @GetMapping("/drone")
  public List<Drone> findAll() {
    return droneService.findAll();
  }

  @GetMapping("/drone/{id}")
  public Optional<Drone> findById(@PathVariable Integer id) {
    return droneService.findDroneById(id);
  }

  @PostMapping("/drone")
  public Drone create(@RequestBody Drone drone) {
    return droneService.create(drone);
  }

  @DeleteMapping("/drone/{id}")
  public Drone testDrone(@PathVariable Integer id, @RequestBody Drone drone) {
    return drone;
  }
}

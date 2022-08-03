package group.one.dronefeeder.controller;

import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.repository.DroneRepository;
import group.one.dronefeeder.service.DroneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import group.one.dronefeeder.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

/**
 * DroneController.
 */
@RestController
@RequestMapping("/dronefeeder/drone")
public class DroneController {
  @Autowired
  private DroneService droneService;

  @GetMapping
  public List<Drone> findAll() {
    return droneService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Drone> findById(@PathVariable Long id) {
    return droneService.findDroneById(id);
  }

  @PostMapping
  public Drone create(@RequestBody Drone drone) {
    return droneService.create(drone);
  }

  @PutMapping("/{id}")
  public Drone update(@RequestBody Drone drone, @PathVariable Long id) {
    return droneService.updateById(id, drone);
  }

  @DeleteMapping("/{id}")
  public void testDrone(@PathVariable Long id) {
    droneService.delete(id);
  }
}

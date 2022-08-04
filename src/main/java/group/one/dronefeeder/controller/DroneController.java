package group.one.dronefeeder.controller;

import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.service.DroneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DroneController.
 */
@CrossOrigin
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

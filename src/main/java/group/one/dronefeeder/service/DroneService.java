package group.one.dronefeeder.service;

import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Class DroneService.
 */
@Service
public class DroneService {
  @Autowired
  DroneRepository droneJpaRepository;
  @Autowired
  DroneRepository droneRepository;

  /**
   * Create.
   */
  public Drone create(Drone drone) {
    if (droneRepository.existsByMarca(drone.getMarca())) {
      throw new DroneExistenteException();
    }
    return droneJpaRepository.save(drone);
  }

  public List<Drone> findAll() {
    return droneJpaRepository.findAll();
  }

  public Optional<Drone> findDroneById(Integer id) {
    return droneJpaRepository.findById(id);
  }
}

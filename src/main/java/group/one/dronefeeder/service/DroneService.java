package group.one.dronefeeder.service;

import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class DroneService.
 */
@Service
public class DroneService {
  @Autowired
  DroneRepository droneJpaRepository;

  /**
   * Create.
   */
  public Drone create(Drone drone) {
    return droneJpaRepository.save(drone);
  }

  public List<Drone> findAll() {
    return droneJpaRepository.findAll();
  }

}

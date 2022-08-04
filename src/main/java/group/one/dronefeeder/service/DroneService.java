package group.one.dronefeeder.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group.one.dronefeeder.exception.ExistenteException;
import group.one.dronefeeder.exception.NotFoundException;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.repository.DroneRepository;

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
    if (droneJpaRepository.existsByMarca(drone.getMarca())) {
      throw new ExistenteException("Drone Already Existe");
    }
    return droneJpaRepository.save(drone);
  }

  public List<Drone> findAll() {
    return droneJpaRepository.findAll();
  }

  public Optional<Drone> findDroneById(Long id) {
    return droneJpaRepository.findById(id);
  }

  public void delete(Long id) {
    Drone drone = droneJpaRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Não encontrado id"));
    droneJpaRepository.deleteById(drone.getId());
  }

  public Drone updateById(Long id, Drone drone) {
    Optional<Drone> oldDrone = droneJpaRepository.findById(id);
    if (oldDrone.isPresent()) {
      Drone updateDrone = oldDrone.get();
      if (drone.getMarca() != null) {
        updateDrone.setMarca(drone.getMarca());
      }
      if (drone.getModelo() != null) {
        updateDrone.setModelo(drone.getModelo());
      }
      droneJpaRepository.save(updateDrone);
      return updateDrone;
    }
    return null;
  }
}

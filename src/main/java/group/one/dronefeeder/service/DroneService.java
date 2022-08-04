package group.one.dronefeeder.service;

import group.one.dronefeeder.exception.DeliveryNotFoundException;
import group.one.dronefeeder.exception.DroneExistenteException;
import group.one.dronefeeder.exception.NotFoundException;
import group.one.dronefeeder.model.Delivery;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
      throw new DroneExistenteException();
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
    Drone drone = droneJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Não encontrado id"));
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

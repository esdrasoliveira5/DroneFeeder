package group.one.dronefeeder.repository;

import group.one.dronefeeder.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DroneRepository.
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
  boolean existsByMarca(String marca);
}

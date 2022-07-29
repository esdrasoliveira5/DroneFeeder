package group.one.dronefeeder.repository;

import group.one.dronefeeder.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Integer> {
  boolean existsByNome(String nome);
}

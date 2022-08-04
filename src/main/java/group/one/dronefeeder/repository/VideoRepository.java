package group.one.dronefeeder.repository;

import group.one.dronefeeder.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * VideoRepository.
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
  // boolean existsByDateAndTime(Drone drone, Date date);
}

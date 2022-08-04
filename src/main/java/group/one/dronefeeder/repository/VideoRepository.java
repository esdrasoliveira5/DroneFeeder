package group.one.dronefeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import group.one.dronefeeder.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
  // boolean existsByDateAndTime(Drone drone, Date date);
}

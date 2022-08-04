package group.one.dronefeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import group.one.dronefeeder.model.Delivery;
import group.one.dronefeeder.model.Video;

/**
 * DeliveryRepository.
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  boolean existsByVideo(Video video);
}

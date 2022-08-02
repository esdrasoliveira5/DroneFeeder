package group.one.dronefeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import group.one.dronefeeder.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

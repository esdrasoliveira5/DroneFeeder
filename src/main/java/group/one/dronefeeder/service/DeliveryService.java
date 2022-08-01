package group.one.dronefeeder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group.one.dronefeeder.exception.DeliveryExistenceException;
import group.one.dronefeeder.exception.DeliveryNotFoundException;
import group.one.dronefeeder.model.Delivery;
import group.one.dronefeeder.repository.DeliveryRepository;

/**
 * Delivery Service.
 */
@Service
public class DeliveryService {
  @Autowired
  DeliveryRepository repository;

  public List<Delivery> findAll() {
    return repository.findAll();
  }

  public Delivery findOne(Long id) {
    return repository.findById(id).orElseThrow(() -> new DeliveryNotFoundException());
  }

  public Delivery create(Delivery delivery) {
    if (repository.existsByDateAndTime(delivery.getDateAndTime())) {
      throw new DeliveryExistenceException();
    }

    return repository.save(delivery);
  }

  public void delete(Long id) {

    Delivery delivery = repository.findById(id).orElseThrow(() -> new DeliveryNotFoundException());

    repository.deleteById(delivery.getId());
  }

}

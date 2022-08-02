package group.one.dronefeeder.service;

import java.util.Date;
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
    // if (repository.existsByDateAndTime(delivery.getDateAndTime())) {
    //   throw new DeliveryExistenceException();
    // }
    return repository.save(delivery);
  }


  public Delivery update(Long id, Delivery delivery) {
    Delivery oldDelivery =
        repository.findById(id).orElseThrow(() -> new DeliveryNotFoundException());
    oldDelivery.setDrone(delivery.getDrone());
    oldDelivery.setLatitude(delivery.getLatitude());
    oldDelivery.setLongitude(delivery.getLongitude());
    repository.save(delivery);
    return delivery;
  }

  public Delivery patch(Long id) {
    Delivery delivery = repository.findById(id).orElseThrow(() -> new DeliveryNotFoundException());
    Date date = new Date();
    delivery.setDeliveryStatus(true);
    delivery.setDeliveryDateAndTime(date);
    repository.save(delivery);
    return delivery;
  }

  public void delete(Long id) {

    Delivery delivery = repository.findById(id).orElseThrow(() -> new DeliveryNotFoundException());

    repository.deleteById(delivery.getId());
  }

}

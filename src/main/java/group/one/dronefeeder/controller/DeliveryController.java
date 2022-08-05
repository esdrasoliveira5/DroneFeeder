package group.one.dronefeeder.controller;

import group.one.dronefeeder.dto.DeliveryCreateDto;
import group.one.dronefeeder.dto.DeliveryUpdateDto;
import group.one.dronefeeder.model.Delivery;
import group.one.dronefeeder.service.DeliveryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Delivery Controller.
 */
@CrossOrigin
@RestController
@RequestMapping("/dronefeeder")
public class DeliveryController {

  @Autowired
  private DeliveryService service;

  @GetMapping("/delivery")
  public List<Delivery> getAll() {
    return service.findAll();
  }

  @GetMapping("/delivery/{id}")
  public Delivery getOne(@PathVariable Long id) {
    return service.findOne(id);
  }

  @PostMapping("/delivery")
  public Delivery create(@RequestBody DeliveryCreateDto delivery) {
    return service.create(delivery);
  }

  @PutMapping("/delivery/{id}")
  public Delivery update(@PathVariable Long id, DeliveryUpdateDto delivery) {
    return service.update(id, delivery);
  }

  @PatchMapping("/delivery/{id}/finish")
  public Delivery patch(@PathVariable Long id) {
    return service.patch(id);
  }

  @DeleteMapping("/delivery/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}

package group.one.dronefeeder.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private String brand;

  @Column
  private String model;

  @Column
  @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Delivery> deliveries;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public List<Delivery> getDeliveries() {
    return deliveries;
  }

  public void setDeliveries(List<Delivery> deliveries) {
    this.deliveries = deliveries;
  }
}

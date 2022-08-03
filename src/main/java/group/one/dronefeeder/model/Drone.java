package group.one.dronefeeder.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drone")
public class Drone {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_drone")
  private Long id;
  @Column
  private String marca;
  @Column
  private String modelo;

  @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Delivery> deliveries;

  public Drone() {}

  public Drone(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }
}

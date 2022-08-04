package group.one.dronefeeder.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "drone")
public class Drone {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String marca;
  @Column(nullable = false)
  private String modelo;
  @OneToMany(mappedBy = "drone")
  private List<Delivery> deliveries;

  public Drone() {
  }

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

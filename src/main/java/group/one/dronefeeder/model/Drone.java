package group.one.dronefeeder.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "drone")
public class Drone {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_drone")
  private Integer id;
  @Column
  private String marca;
  @Column
  private String modelo;

  public Drone() {
  }

  public Drone(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

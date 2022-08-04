package group.one.dronefeeder.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_video")
public class Video {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String url;

  @ManyToOne
  @JoinColumn(name = "drone_id")
  private Drone drone;

  @OneToOne(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private Delivery delivery;

  public Video() {}

  public Video(String url, Drone drone) {
    this.url = url;
    this.drone = drone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

}

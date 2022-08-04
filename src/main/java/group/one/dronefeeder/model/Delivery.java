package group.one.dronefeeder.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_delivery")
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String latitude;

  @Column
  private String longitude;

  @Column
  private Date dateAndTime;

  @Column
  private boolean deliveryStatus;

  @Column
  private Date deliveryDateAndTime;

  @ManyToOne
  @JoinColumn(name = "drone_id")
  private Drone drone;

  @JoinColumn(name = "video_id")
  @OneToOne
  private Video video;

  public Delivery(String latitude, String longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Delivery(String latitude, String longitude, Drone drone, Video video) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.drone = drone;
    this.video = video;
    this.dateAndTime = new Date();
    this.deliveryStatus = false;
    this.deliveryDateAndTime = null;
  }

  public Delivery() {
    this.dateAndTime = new Date();
    this.deliveryStatus = false;
    this.deliveryDateAndTime = null;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Date getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(Date dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public boolean getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(boolean deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public Date getDeliveryDateAndTime() {
    return deliveryDateAndTime;
  }

  public void setDeliveryDateAndTime(Date deliveryDateAndTime) {
    this.deliveryDateAndTime = deliveryDateAndTime;
  }

}

package group.one.dronefeeder.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "drone_id")
  private Drone drone;

}

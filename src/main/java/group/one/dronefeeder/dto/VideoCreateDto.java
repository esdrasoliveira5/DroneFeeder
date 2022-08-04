package group.one.dronefeeder.dto;

public class VideoCreateDto {

  private String url;

  private Long drone;

  private Long delivery;

  public VideoCreateDto(String url, Long drone, Long delivery) {
    this.setUrl(url);
    this.setDrone(drone);
    this.setDelivery(delivery);
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Long getDrone() {
    return drone;
  }

  public void setDrone(Long drone) {
    this.drone = drone;
  }

  public Long getDelivery() {
    return delivery;
  }

  public void setDelivery(Long delivery) {
    this.delivery = delivery;
  }
}

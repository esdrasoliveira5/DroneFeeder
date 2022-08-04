package group.one.dronefeeder.dto;

public class DeliveryCreateDto {
  private String latitude;

  private String longitude;

  private Long drone;

  private Long video;

  public DeliveryCreateDto(String latitude, String longitude, Long drone, Long video) {
    this.setLatitude(latitude);
    this.setLongitude(longitude);
    this.setDrone(drone);
    this.setVideo(video);
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public long getDrone() {
    return drone;
  }

  public void setDrone(long drone) {
    this.drone = drone;
  }

  public Long getVideo() {
    return video;
  }

  public void setVideo(Long video) {
    this.video = video;
  }
}

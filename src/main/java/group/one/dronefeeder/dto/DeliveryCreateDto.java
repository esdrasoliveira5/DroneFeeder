package group.one.dronefeeder.dto;

public class DeliveryCreateDto {
  private String latitude;

  private String longitude;

  private long drone;

  public DeliveryCreateDto(String latitude, String longitude, Long drone) {
    this.setLatitude(latitude);
    this.setLongitude(longitude);
    this.setDrone(drone);
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
}

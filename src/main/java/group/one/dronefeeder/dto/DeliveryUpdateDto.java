package group.one.dronefeeder.dto;

/**
 * DeliveryUpdateDto.
 */
public class DeliveryUpdateDto {

  private String latitude;

  private String longitude;

  public DeliveryUpdateDto(String latitude, String longitude) {
    this.setLatitude(latitude);
    this.setLongitude(longitude);
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
}

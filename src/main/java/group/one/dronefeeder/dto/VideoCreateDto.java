package group.one.dronefeeder.dto;

/**
 * VideoCreateDto.
 */
public class VideoCreateDto {

  private String url;

  private Long drone;

  public VideoCreateDto(String url, Long drone) {
    this.setUrl(url);
    this.setDrone(drone);
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
}

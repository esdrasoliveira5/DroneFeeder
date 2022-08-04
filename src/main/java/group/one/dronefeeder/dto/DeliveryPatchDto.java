package group.one.dronefeeder.dto;

public class DeliveryPatchDto {

  private Long video;

  public DeliveryPatchDto(Long video) {
    this.video = video;
  }

  public Long getVideo() {
    return video;
  }

  public void setVideo(Long video) {
    this.video = video;
  }
}

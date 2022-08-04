package group.one.dronefeeder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group.one.dronefeeder.dto.VideoCreateDto;
import group.one.dronefeeder.exception.NotFoundException;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.model.Video;
import group.one.dronefeeder.repository.DeliveryRepository;
import group.one.dronefeeder.repository.DroneRepository;
import group.one.dronefeeder.repository.VideoRepository;

@Service
public class VideoService {

  @Autowired
  DeliveryRepository deliveryRepository;

  @Autowired
  DroneRepository droneRepository;

  @Autowired
  VideoRepository repository;

  public List<Video> findAll() {
    return repository.findAll();
  }

  public Video findOne(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Video Not Found!"));
  }

  public Video create(VideoCreateDto video) {
    Drone drone = droneRepository.findById(video.getDrone())
        .orElseThrow(() -> new NotFoundException("Drone Not Found!!"));

    Video newVideo = new Video(video.getUrl(), drone);
    return repository.save(newVideo);
  }
}

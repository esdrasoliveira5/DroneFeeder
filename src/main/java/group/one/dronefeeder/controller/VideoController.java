package group.one.dronefeeder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import group.one.dronefeeder.dto.VideoCreateDto;
import group.one.dronefeeder.model.Video;
import group.one.dronefeeder.service.VideoService;

@CrossOrigin
@RestController
@RequestMapping("/dronefeeder")
public class VideoController {
  @Autowired
  private VideoService service;

  @GetMapping("/video")
  public List<Video> findAll() {
    return service.findAll();
  }

  @GetMapping("/video/{id}")
  public Video findById(@PathVariable Long id) {
    return service.findOne(id);
  }

  @PostMapping("/video")
  public Video create(@RequestBody VideoCreateDto data) {
    return service.create(data);
  }
}

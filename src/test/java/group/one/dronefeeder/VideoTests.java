package group.one.dronefeeder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import group.one.dronefeeder.repository.DroneRepository;
import group.one.dronefeeder.repository.VideoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
public class VideoTests {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private DroneRepository droneRepository;

  @SpyBean
  private VideoRepository videoRepository;

  @BeforeEach
  public void setup() {
    droneRepository.deleteAll();
    videoRepository.deleteAll();
  }

  @Test
  @DisplayName("1 - Deve retornar uma lista vazia quando nao houver videos")
  void deveRetornarListaVaziaQuandoNaoHouverVideos() throws Exception {
    final var resposta = mockMvc.perform(get("/dronefeeder/video"));
    resposta.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().string(containsString("[]")));
  }

  @Test
  @DisplayName("2 - Deve retornar Not Found quando nao houver delivery")
  void deveRetornarNotFoundQuandoNaoHouverVideo() throws Exception {
    final var resposta = mockMvc.perform(get("/dronefeeder/video/1"));
    resposta.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().string(containsString("Video Not Found!")));
  }
}

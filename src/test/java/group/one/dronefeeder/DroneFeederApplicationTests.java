package group.one.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import group.one.dronefeeder.model.Drone;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
class DroneFeederApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  @Order(1)
  @DisplayName("1 - Deve adicionar um drone")
  void deveAdicionarDrone() throws Exception {
    final var drone = new Drone("leo", "mar");
    mockMvc.perform(post("/dronefeeder/drone").contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(drone)))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(jsonPath("$.marca").value(drone.getMarca()));
  }
}

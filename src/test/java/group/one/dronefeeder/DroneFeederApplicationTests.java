package group.one.dronefeeder;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
class DroneFeederApplicationTests {
  // @Autowired
  // private MockMvc mockMvc;
  //
  // @Test
  // @Order(1)
  // @DisplayName("1 - Deve adicionar um drone")
  // void deveAdicionarDrone() throws Exception {
  // final var drone = new Drone("leo12", "mar12");
  // mockMvc
  // .perform(post("/dronefeeder/drone").contentType(MediaType.APPLICATION_JSON)
  // .content(new ObjectMapper().writeValueAsString(drone)))
  // .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
  // .andExpect(jsonPath("$.marca").value(drone.getMarca()));
  // }
}

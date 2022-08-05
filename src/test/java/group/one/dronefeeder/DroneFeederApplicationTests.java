package group.one.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.one.dronefeeder.model.Drone;
import group.one.dronefeeder.repository.DroneRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DroneFeederApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private DroneRepository droneRepository;

  @Captor
  private ArgumentCaptor<Drone> droneCaptor;

  @BeforeEach
  public void setup() {
    droneRepository.deleteAll();
  }

  @Test
  @Order(1)
  @DisplayName("1 - Deve adicionar um drone")
  void deveAdicionarDrone() throws Exception {
    final var drone = new Drone("leo12", "mar12");
    mockMvc
        .perform(post("/dronefeeder/drone").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(drone)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.marca").value(drone.getMarca()));
  }

  @Test
  @Order(2)
  @DisplayName("2 - Deve retornar todos os drones.")
  void deveListarUmDrone() throws Exception {
    final var drone1 = new Drone("leo12", "mar12");
    final var drone2 = new Drone("leo1212", "mar1212");
    final var drone3 = new Drone("Drone Esio", "mar echo esio");

    droneRepository.save(drone1);
    droneRepository.save(drone2);
    droneRepository.save(drone3);

    mockMvc.perform(get("/dronefeeder/drone").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].marca").value(drone1.getMarca()))
        .andExpect(jsonPath("$[0].modelo").value(drone1.getModelo()))
        .andExpect(jsonPath("$[1].marca").value(drone2.getMarca()))
        .andExpect(jsonPath("$[1].modelo").value(drone2.getModelo()));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Deve retornar Um drone.")
  void deveRetornarTempoGastoDeTodosEpisodiosMesmoSeNaoHouverEpisodio() throws Exception {
    final var drone = droneRepository.save(new Drone("leo12", "mar12"));
    mockMvc
        .perform(get("/dronefeeder/drone/" + drone.getId()).contentType(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.marca").value(drone.getMarca()))
        .andExpect(jsonPath("$.modelo").value(drone.getModelo()));
  }

  @Test
  @Order(4)
  @DisplayName("4 - Deve retornar erro 409, caso tente inserir mesma informação.")
  void deveRetornarErroMesmaInfo() throws Exception {
    final var drone = droneRepository.save(new Drone("leo12", "mar12"));
    mockMvc
        .perform(post("/dronefeeder/drone").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(drone)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isConflict());
  }

  @Test
  @Order(5)
  @DisplayName("5 - Deve remover drone, por um id existente informado.")
  void deveRemoverDroneQuandoExistirNaBase() throws Exception {
    final var drone = droneRepository.save(new Drone("leo12", "mar12"));;

    mockMvc.perform(delete("/dronefeeder/drone/" + drone.getId())).andExpect(status().isOk());
  }
}

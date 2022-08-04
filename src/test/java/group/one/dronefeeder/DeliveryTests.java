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
class DeliveryTests {
  // @Autowired
  // private MockMvc mockMvc;
  //
  // @Test
  // @DisplayName("1 - Deve retornar uma lista vazia quando nao houver delivery")
  // void deveRetornarListaVaziaQuandoNaoHouverDelivery() throws Exception {
  // final var resposta = mockMvc.perform(get("/dronefeeder/delivery"));
  // resposta.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
  // .andExpect(content().string(containsString("[]")));
  // }
  //
  // @Test
  // @DisplayName("2 - Deve retornar uma lista vazia quando nao houver delivery")
  // void deveRetornarNotFoundQuandoNaoHouverDelivery() throws Exception {
  // final var resposta = mockMvc.perform(get("/dronefeeder/delivery/1"));
  // resposta.andExpect(content().contentType(MediaType.APPLICATION_JSON))
  // .andExpect(status().isNotFound())
  // .andExpect(content().string(containsString("Delivery Not Found!")));
  // }
  //
  // @Test
  // @DisplayName("3 - Deve retornar uma lista vazia quando nao houver delivery")
  // void deveCriarUmDelivery() throws Exception {
  //
  // }

}

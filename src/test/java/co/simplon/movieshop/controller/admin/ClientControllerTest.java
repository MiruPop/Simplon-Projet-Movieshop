package co.simplon.movieshop.controller.admin;

import co.simplon.movieshop.service.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
class ClientControllerTest {
    private static final String ENDPOINT = "/movieshop/admin/client/";

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ApplicationContext context;
    @MockBean
    ClientServiceImpl service;

    @BeforeEach
    void setup() {
//    WebAppContext setup
    }

//    @Test
//    void listerClients_returns_status_200() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/movieshop/admin/client/all")
//                        .accept(MediaType.APPLICATION_JSON)
//                        )
//
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nrClient").exists());
////                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nrClient").value("1"));
//    }
}
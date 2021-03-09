package dz.chicov.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void index() throws Exception{
        mockMvc.perform(get("/index/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    void oups() throws Exception {
        mockMvc.perform(get("/oups/")).andExpect(status().isOk()).andExpect(view().name("oups"));
    }

}
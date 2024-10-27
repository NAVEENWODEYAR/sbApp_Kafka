package com.gowri.controller;

/*
 * @author NaveenWodeyar
 * @date 23-10-2024
 */

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpController.class)
public class EmpControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EmpController empController;

    @Mock
    private Environment environment;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
    }

    @Test
    public void testEndPoint() throws Exception {
        when(environment.getProperty("server.port", "8080")).thenReturn("8080");

        mockMvc.perform(get("/emp")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Dairy Employee App connected, running on port: 8080"));
    }
}

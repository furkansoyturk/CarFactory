package com.example.car.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetRequestsToCars_thenReturns200_andValidTypes() throws Exception {
        mockMvc.perform(
                        get("/cars/")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].type").value("Sedan"))
                .andExpect(jsonPath("$.[0].color").value("Black"))
                .andExpect(jsonPath("$.[0].model").value("A431"))
                .andExpect(jsonPath("$.[1].type").value("Cabrio"))
                .andExpect(jsonPath("$.[1].color").value("Yellow"))
                .andExpect(jsonPath("$.[1].model").value("S432"))
                .andExpect(jsonPath("$.[2].type").value("Hatchback"))
                .andExpect(jsonPath("$.[2].color").value("Blue"))
                .andExpect(jsonPath("$.[2].model").value("V12"));
    }
}

package com.example.immutableexample;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CarRepoService carRepoService;

    @Test
    public void getCarsTest() throws Exception {

        String VIN = "111";
        String number = "a007";
        String param = "?VIN=111&number=a007";

        carRepoService.clearCars();
        carRepoService.addCar(new Car(number,VIN,null));

        mockMvc.perform(get("http://localhost:8080/api/v1/cars"+param))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(carRepoService.getCars().toString())));

    }

    @Test
    public void getCarsTest404() throws Exception {

        String VIN = "222";
        String number = "a009";
        String param = "?VIN=111&number=a007";

        carRepoService.clearCars();
        carRepoService.addCar(new Car(number,VIN,null));

        mockMvc.perform(get("http://localhost:8080/api/v1/cars"+param))
                .andExpect(status().isNotFound());

    }
}
package com.example.car.service;

import com.example.car.model.ProduceRequestDTO;
import com.example.car.model.ProduceResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    void givenValidCarType_toProduce_thenReturnProducedCarWithMessage() {

        ProduceRequestDTO request = new ProduceRequestDTO();
        request.setType("Sedan");

        ProduceResponseDTO expectedResponse = new ProduceResponseDTO();
        expectedResponse.setType("Sedan");
        expectedResponse.setMessage("Sedan");

        ProduceResponseDTO actualResponse = carService.produce(request);

        assert actualResponse.getType().equals(expectedResponse.getType());
        assert actualResponse.getMessage().equals(expectedResponse.getMessage());
    }

    @Test
    void givenInvalidCarType_toProduce_thenReturnCustomExceptionMessage() {
        ProduceRequestDTO request = new ProduceRequestDTO();
        request.setType("randomInput");

        String expectedErrorMessage = "Requested car type does not exist. Please request a valid type to produce a car";

        try {
            carService.produce(request);
        } catch (Exception e) {
            String actualErrorMessage = e.getMessage();
            assert expectedErrorMessage.equals(actualErrorMessage);
        }
    }
}

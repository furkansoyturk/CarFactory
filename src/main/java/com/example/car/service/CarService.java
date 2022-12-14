package com.example.car.service;

import com.example.car.exception.InvalidRequestException;
import com.example.car.model.*;
import com.example.car.repository.CarRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    List<Car> carTypes;

    @Autowired
    @Qualifier("ObjMapper")
    ObjectMapper mapper;

    public List<CarFactoryResponseDTO> findAll() {
        List<CarFactory> carRepositoryAll = carRepository.findAll();
        List<CarFactoryResponseDTO> responseDTOList = mapper.convertValue(carRepositoryAll, new TypeReference<>() {
        });
        return responseDTOList;
    }

    public ProduceResponseDTO produce(ProduceRequestDTO request) {
        Car car = typeFinder(request.getType());
        ProduceResponseDTO responseDTO = new ProduceResponseDTO();
        responseDTO.setMessage(car.getType());
        responseDTO.setType(car.getType());
        return responseDTO;
    }

    private Car typeFinder(String carType) {
        return carTypes.stream()
                .filter(obj -> obj.getType().equalsIgnoreCase(carType))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestException("Requested car type does not exist. Please request a valid type to produce a car"));
    }
}
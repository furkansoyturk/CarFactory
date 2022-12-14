package com.example.car.controller;


import com.example.car.model.CarFactoryResponseDTO;
import com.example.car.model.ProduceRequestDTO;
import com.example.car.model.ProduceResponseDTO;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CarFactoryResponseDTO>> findAll() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/produce")
    public ResponseEntity<ProduceResponseDTO> produce(@RequestBody ProduceRequestDTO request) {
        return new ResponseEntity<>(carService.produce(request), HttpStatus.CREATED);
    }

}

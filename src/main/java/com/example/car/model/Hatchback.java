package com.example.car.model;

import org.springframework.stereotype.Component;

@Component
public class Hatchback implements Car{
    @Override
    public String getType() {
        return "Hatchback";
    }
}

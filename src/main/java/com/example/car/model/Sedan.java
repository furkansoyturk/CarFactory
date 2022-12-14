package com.example.car.model;

import org.springframework.stereotype.Component;

@Component
public class Sedan implements Car{
    @Override
    public String getType() {
        return "Sedan";
    }
}

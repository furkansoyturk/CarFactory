package com.example.car.model;

import org.springframework.stereotype.Component;

@Component
public class Cabrio implements Car{
    @Override
    public String getType() {
        return "Cabrio";
    }
}

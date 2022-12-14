package com.example.car.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*
    Fake entity with representative purpose.
 */
@Setter
@Getter
@EqualsAndHashCode
public class CarFactory {
    private String type;

    private String color;

    private String model;
}

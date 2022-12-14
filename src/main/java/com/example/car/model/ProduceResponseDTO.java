package com.example.car.model;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors
public class ProduceResponseDTO {
    private String type;

    @Setter(AccessLevel.NONE)
    private String message;

    public void setMessage(String type) {
        this.message = String.format("%s Car has produced.",type);
    }
}

package com.racloop.tdd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Car {
    private String id;
    private String name;
    private String type;

    public Car(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

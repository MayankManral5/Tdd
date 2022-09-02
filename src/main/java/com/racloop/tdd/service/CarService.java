package com.racloop.tdd.service;

import com.racloop.tdd.domain.Car;
import com.racloop.tdd.exception.CarNotFoundException;
import com.racloop.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name );
        if (Objects.isNull(car))
            throw new CarNotFoundException();
        return car;
    }
}

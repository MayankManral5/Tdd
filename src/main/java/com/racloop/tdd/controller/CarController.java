package com.racloop.tdd.controller;

import com.racloop.tdd.domain.Car;
import com.racloop.tdd.exception.CarNotFoundException;
import com.racloop.tdd.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/{carName}")
    public Car getCar(@PathVariable String carName){
        return carService.getCarDetails(carName);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex){

    }
}

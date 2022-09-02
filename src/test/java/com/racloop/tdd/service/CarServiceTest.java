package com.racloop.tdd.service;

import com.racloop.tdd.domain.Car;
import com.racloop.tdd.exception.CarNotFoundException;
import com.racloop.tdd.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception{
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetailsReturnCarInfo(){
        given(carRepository.findByName("swift")).willReturn(new Car("swift", "petrol"));

        Car car = carService.getCarDetails("swift");
        Assertions.assertThat(car.getName()).isEqualTo("swift");
        Assertions.assertThat(car.getType()).isEqualTo("petrol");

    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception{
        given(carRepository.findByName("swift1")).willReturn(null);

        carService.getCarDetails("swift1");
    }
}

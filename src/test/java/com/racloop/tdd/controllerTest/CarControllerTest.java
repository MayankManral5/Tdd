package com.racloop.tdd.controllerTest;

import com.racloop.tdd.controller.CarController;
import com.racloop.tdd.domain.Car;
import com.racloop.tdd.exception.CarNotFoundException;
import com.racloop.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.ArgumentMatchers.anyString;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;
//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    public void getCarTest() throws Exception {
        BDDMockito.given(carService.getCarDetails(anyString())).willReturn(new Car("swift", "petrol"));
        mockMvc.perform(MockMvcRequestBuilders.get("/car/swift"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name  ").value("swift"))
                .andExpect(jsonPath("type").value("petrol"));
    }

//    @Test
//    public void carNotFound() throws Exception{
//        BDDMockito.given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
//        mockMvc.perform(MockMvcRequestBuilders.get("/car/swift"))
//                .andExpect(status().isNotFound());
//    }
}

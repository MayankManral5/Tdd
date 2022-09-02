package com.racloop.tdd.service;

import com.racloop.tdd.exception.CarNotFoundException;
import com.racloop.tdd.exception.CityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

@RunWith(MockitoJUnitRunner.class)
public class PopulationTest {

    public Population population;

    @Before
    public void setUp() throws Exception{
        population = new Population();
    }
    @Test
    public void testPopulation(){
        String cityName = "Delhi";
        Integer expected = 2785349;
        Assertions.assertEquals(expected, population.getPopulation(cityName));
    }

    @Test(expected = NullPointerException.class)
    public void testPopulationWithNullValue(){
        String cityName = "";
        Integer expected = 0;
        Assertions.assertEquals(expected, population.getPopulation(cityName));
    }

    @Test(expected = CityNotFoundException.class)
    public void test(){
        String cityName = "xyz";
        Assertions.assertEquals(CityNotFoundException.class, population.getPopulation(cityName));
    }
}

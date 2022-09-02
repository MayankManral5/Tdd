package com.racloop.tdd.service;

import com.racloop.tdd.exception.CityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Population {

    public Integer getPopulation(String cityName){
        if (cityName.isEmpty())
            throw new NullPointerException();
        Map<String, Integer> population = getPopulationNo();
        Integer populationValue = population.get(cityName);
        if (Objects.isNull(populationValue))
            throw new CityNotFoundException();
        return population.get(cityName);
    }

    public Map<String, Integer> getPopulationNo(){
        Map<String, Integer> population = new HashMap<>();

        population.put("Delhi", 2785349);
        population.put("gurgaon", 23448244);
        population.put("chandigarh", 23435434);
        population.put("zirakpur", 36476428);
        return population;
    }
}

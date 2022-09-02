package com.racloop.tdd.repository;

import com.racloop.tdd.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    public Car findByName(String carName);

}

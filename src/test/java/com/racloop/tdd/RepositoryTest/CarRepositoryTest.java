package com.racloop.tdd.RepositoryTest;

import com.racloop.tdd.domain.Car;
import com.racloop.tdd.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;


    @Test
    public void testFindByName() {
        Car car = repository.findByName("swift");
        assertTrue(Objects.isNull(car));
    }

    @BeforeEach
    void setUp() {
        repository.save(new Car("swift", "petrol"));
    }

//    @AfterEach
//    void tearDown() {
//        repository.deleteAll();
//    }

    @Test
    public void getCar_ReturnsCarDetails() throws Exception{

        Car car = repository.findByName("swift");
       Assertions.assertThat(car.getName()).isEqualTo("swift");
//        Assertions.assertThat(car.getType()).isEqualTo("petrol");
    }

}

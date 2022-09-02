package com.racloop.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CircleTest {

    @Autowired
    public Circle circle;

    @Test
    public void computeAreaOfCircleTest(){
        double radius = 7;
        double expectedResult = 153.93804002589985;
        Assertions.assertEquals(expectedResult, circle.computeAreaOfCircle(radius));
    }


    @Test
    public void computeAreaOfCircleWithDiffRadius(){
        double radius = 8;
        double expectedResult = 201.06192982974676;
        Assertions.assertEquals(expectedResult, circle.computeAreaOfCircle(radius));
    }

}

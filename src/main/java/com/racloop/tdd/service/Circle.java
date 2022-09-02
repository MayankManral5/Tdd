package com.racloop.tdd.service;

import org.springframework.stereotype.Service;

import java.math.MathContext;

@Service
public class Circle {

    public double computeAreaOfCircle(double radius){
        return Math.PI*radius*radius;
    }

}

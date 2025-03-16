package com.example.learn.spring.util.designpattern;


public class Boss {

    public void viewCar() {
        CarFactory carFactory = new CarFactory();
        carFactory.viewCar("HONDA");
        carFactory.viewCar("NEXUS");
        carFactory.viewCar("TOYOTA");
    }

}


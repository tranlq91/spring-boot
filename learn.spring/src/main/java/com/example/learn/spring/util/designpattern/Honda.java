package com.example.learn.spring.util.designpattern;

public class Honda implements Car {
    @Override
    public void view() {
        System.out.printf("%s View", Car.class.getName());
    }
}

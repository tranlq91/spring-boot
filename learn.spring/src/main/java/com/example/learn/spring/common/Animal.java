package com.example.learn.spring.common;

public interface Animal {

    String name = null;

    default void move() {
        System.out.println("This animal is moving");
    };

    void eat();
}

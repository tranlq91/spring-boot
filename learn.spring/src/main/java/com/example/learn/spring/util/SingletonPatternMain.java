package com.example.learn.spring.util;

public class SingletonPatternMain {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern ---");
        SingletonPattern single1 = SingletonPattern.getInstance();
        SingletonPattern single2 = SingletonPattern.getInstance();

        if (single1.equals(single2)) {
            System.out.println("Unique instance");
        }
    }
}

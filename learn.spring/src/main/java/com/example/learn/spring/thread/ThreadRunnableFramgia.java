package com.example.learn.spring.thread;

public class ThreadRunnableFramgia implements Runnable {
    @Override
    public void run() {
        System.out.println();
        for (int x = 1; x <= 3; x++) {
            System.out.println(x + " Thread name: " + Thread.currentThread().getName());
        }
    }
}

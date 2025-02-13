package com.example.learn.spring.thread;

public class TestThreadFramgia {
    public static void main(String[] args) {
        //Tạo ra luồng t1 từ class ThreadFramgia
        ThreadFramgia t1 = new ThreadFramgia();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        //Tạo ra luồng t2 từ class ThreadFramgia
        ThreadFramgia t2 = new ThreadFramgia();
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();

        //Tạo ra luồng t3 từ class ThreadFramgia
        ThreadFramgia t3 = new ThreadFramgia();
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();
    }
}

package com.example.learn.spring;

import com.example.learn.spring.connector.DatabaseConnector;
import com.example.learn.spring.service.UserService;
import com.example.learn.spring.service.UserServiceImpl;
import com.example.learn.spring.thread.ThreadFramgia;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

//		Outfit outfit = context.getBean(Outfit.class);
//
//		System.out.println("Instance: " + outfit);
//
//		outfit.wear();
//
//		Girl girl = context.getBean(Girl.class);
//
//		System.out.println("Girl outfit: " + girl.outfit);
//		girl.outfit.wear();
//		System.out.println("Girl Instance: " + girl);
//
//
//
//		GirlService girlService = context.getBean(GirlService.class);
//
//		Girl girl2 = girlService.getRandomGirl();
//
//		System.out.println(girl2);

//		DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
//		mysql.connect();
//
//		DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");
//		mongodb.connect();
//
//		DatabaseConnector postgresql = (DatabaseConnector) context.getBean("postgresqlConnector");
//		postgresql.connect();
//		//Tạo ra luồng t1 từ class ThreadFramgia
//		ThreadFramgia t1 = new ThreadFramgia();
//		t1.start();
//
//		//Tạo ra luồng t2 từ class ThreadFramgia
//		ThreadFramgia t2 = new ThreadFramgia();
//		t2.start();
//
//		//Tạo ra luồng t3 từ class ThreadFramgia
//		ThreadFramgia t3 = new ThreadFramgia();
//		t3.start();

	}

	@Bean
	public CommandLineRunner test(UserService userService) {
		return args -> {
			System.out.println(userService.introduceUser(123));
		};
	}

}

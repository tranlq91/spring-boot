package com.example.learn.spring.connector;

public class PostgreSqlConnector extends DatabaseConnector {
    @Override
    public void connect() {
        System.out.println("Connected to postgresSQL");
    }
}

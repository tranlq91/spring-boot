package com.example.learn.spring;


import com.example.learn.spring.connector.DatabaseConnector;
import com.example.learn.spring.connector.MongoDbConnector;
import com.example.learn.spring.connector.MySqlConnector;
import com.example.learn.spring.connector.PostgreSqlConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Lấy giá trị config từ file application.properties
    @Value("${loda.mysql.url}")
    String mysqlUrl;

    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure() {
        DatabaseConnector mySqlConnector = new MySqlConnector();
        // Set Url
        System.out.println("Config Mysql Url: " + mysqlUrl);
        mySqlConnector.setUrl(mysqlUrl);
        // Set username, password, format, v.v...
        return mySqlConnector;
    }

    @Bean("postgresqlConnector")
    DatabaseConnector postgresqlConnector() {
        DatabaseConnector postgreSqlConnector = new PostgreSqlConnector();
        // Set Url
        System.out.println("Config Postgres Url: " + mysqlUrl);
        postgreSqlConnector.setUrl(mysqlUrl);
        // Set username, password, format, v.v...
        return postgreSqlConnector;
    }

    @Bean("mongodbConnector")
    DatabaseConnector mongodbConfigure() {
        DatabaseConnector mongoDbConnector = new MongoDbConnector();
        mongoDbConnector.setUrl("mongodb://mongodb0.example.com:27017/loda");
        // Set username, password, format, v.v...
        return mongoDbConnector;
    }
}

package com.example.onemorereactivemessagingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@PropertySource("classpath:database.properties")
public class OneMoreReactiveMessagingAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(OneMoreReactiveMessagingAppApplication.class, args);
    }
}


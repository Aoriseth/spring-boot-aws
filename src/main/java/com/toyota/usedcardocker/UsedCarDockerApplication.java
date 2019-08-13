package com.toyota.usedcardocker;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.toyota.usedcardocker.repositories")
public class UsedCarDockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsedCarDockerApplication.class, args);
    }
}

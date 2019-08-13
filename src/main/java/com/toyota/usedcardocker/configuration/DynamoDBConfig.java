package com.toyota.usedcardocker.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.toyota.usedcardocker.repositories")
public class DynamoDBConfig {

    @Value("${awsAccessKey}")
    private String amazonDynamoDBAccessKey;
    @Value("${awsSecretKey}")
    private String amazonDynamoDBSecretKey;

    @Bean
    public AWSCredentials awsCredentials(){
        return new BasicAWSCredentials(amazonDynamoDBAccessKey,amazonDynamoDBSecretKey);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials());
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsStaticCredentialsProvider)
                .withRegion(Regions.EU_WEST_1)
                .build();
    }

    @Bean
    public DynamoDB dynamoDB(){
        return new DynamoDB(amazonDynamoDB());
    }
}

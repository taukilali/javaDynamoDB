package com.taukil.javaDynamoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@SpringBootApplication
public class JavaDynamoDbApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaDynamoDbApplication.class, args);
	}

}

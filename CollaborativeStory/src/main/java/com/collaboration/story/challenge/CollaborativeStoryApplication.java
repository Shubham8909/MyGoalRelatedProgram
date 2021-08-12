package com.collaboration.story.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CollaborativeStoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborativeStoryApplication.class, args);
	}

}

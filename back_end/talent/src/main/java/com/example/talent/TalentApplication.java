package com.example.talent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TalentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentApplication.class, args);
	}

}

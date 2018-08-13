package com.thoughtclan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PlayoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayoAppApplication.class, args);
	}
}

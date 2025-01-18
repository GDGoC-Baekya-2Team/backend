package com.backend.withFesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WithFestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithFestaApplication.class, args);
	}

}

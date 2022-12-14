package com.maria.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ="com.maria" )
@EntityScan(basePackages = "com.maria.entity")
@EnableJpaRepositories (basePackages = "com.maria.persistence")
public class StationsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationsApiApplication.class, args);
	}

}

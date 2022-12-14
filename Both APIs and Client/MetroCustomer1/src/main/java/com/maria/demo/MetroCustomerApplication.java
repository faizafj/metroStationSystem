package com.maria.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ="com.maria" )
@EntityScan(basePackages = "com.maria.entity")
@EnableJpaRepositories("com.maria.persistence")
public class MetroCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroCustomerApplication.class, args);
	}

}

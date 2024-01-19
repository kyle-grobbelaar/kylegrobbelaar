package com.enviro.assessment.grad001.kylegrobbelaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.enviro.assessment.grad001.kylegrobbelaar.Persistence.Interfaces")
@ComponentScan("com.enviro.assessment.grad001.kylegrobbelaar")
public class InvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestorApplication.class, args);
	}

}

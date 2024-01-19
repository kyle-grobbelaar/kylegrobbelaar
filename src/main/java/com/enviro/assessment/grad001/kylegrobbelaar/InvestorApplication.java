package com.enviro.assessment.grad001.kylegrobbelaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.enviro.assessment.grad001.kylegrobbelaar.Persistence.Interfaces")
//@ComponentScan(basePackages = "com.enviro.assessment.grad001.kylegrobbelaar")
//@EntityScan(basePackages = "com.enviro.assessment.grad001.kylegrobbelaar.Common")
public class InvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestorApplication.class, args);
	}

}

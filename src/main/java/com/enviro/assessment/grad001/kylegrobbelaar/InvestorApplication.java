package com.enviro.assessment.grad001.kylegrobbelaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EntityScan
@EnableJpaRepositories
//@EnableTransactionManagement
public class InvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestorApplication.class, args);
	}

}

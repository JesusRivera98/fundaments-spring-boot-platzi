package com.platzifundaments.springboot.fundaments;

import com.platzifundaments.springboot.fundaments.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	public  FundamentsApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
	}
}

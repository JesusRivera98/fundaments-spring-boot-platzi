package com.platzifundaments.springboot.fundaments;

import com.platzifundaments.springboot.fundaments.bean.MyBean;
import com.platzifundaments.springboot.fundaments.bean.MyBeanWithDependency;
import com.platzifundaments.springboot.fundaments.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	public  FundamentsApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}

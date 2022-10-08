package com.fundamentos.springboot.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.springboot.springdemo.bean.MyBean;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithDependency;
import com.fundamentos.springboot.springdemo.component.ComponentDependency;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	
	public SpringDemoApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency,
			MyBean myBean, MyBeanWithDependency myBeanWithDependency) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greeting();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		
	}

}

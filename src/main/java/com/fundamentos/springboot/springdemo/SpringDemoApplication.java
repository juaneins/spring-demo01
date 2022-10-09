package com.fundamentos.springboot.springdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.springboot.springdemo.bean.MyBean;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithDependency;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithProperties;
import com.fundamentos.springboot.springdemo.component.ComponentDependency;
import com.fundamentos.springboot.springdemo.pojo.UserPojo;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {
	
	private final Log logger = LogFactory.getLog(SpringApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo user;
	
	public SpringDemoApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency,
			MyBean myBean, MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties, UserPojo user) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.user = user;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greeting();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		String result = myBeanWithProperties.function();
		System.out.println(result);
		System.out.println(user.toString());
		logger.error("This is an error!!");
	}

}

package com.fundamentos.springboot.springdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.springdemo.bean.MyBean;
//import com.fundamentos.springboot.springdemo.bean.MyBeanImplement;
import com.fundamentos.springboot.springdemo.bean.MyBeanImplement2;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithDependency;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithDependencyImplement;
import com.fundamentos.springboot.springdemo.bean.MyOperation;
import com.fundamentos.springboot.springdemo.bean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {
	
	@Bean
	public MyBean beanOperation() {
		return new MyBeanImplement2();
	}
	
	@Bean
	public MyOperation beanSumOperation() {
		return new MyOperationImplement();
	}
	
	@Bean
	public MyBeanWithDependency beanWithDependencyOperation(MyOperation myOperation) {
		return new MyBeanWithDependencyImplement(myOperation);
	}

}

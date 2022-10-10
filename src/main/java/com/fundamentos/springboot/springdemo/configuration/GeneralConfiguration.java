/**
 * 
 */
package com.fundamentos.springboot.springdemo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.springdemo.bean.MyBeanWithProperties;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.springdemo.pojo.UserPojo;

/**
 * @author juaneins_uio
 *
 */
@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
	
	@Value("${value.name}")
	private String name;
	
	@Value("${value.lastname}")
	private String lastName;
	
	@Value("${value.random}")
	private String random;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(name, lastName);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}
	
}

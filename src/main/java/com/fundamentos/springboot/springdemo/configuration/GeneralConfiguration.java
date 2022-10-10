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
import org.springframework.context.annotation.PropertySource;

import com.fundamentos.springboot.springdemo.bean.MyBeanWithProperties;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.springdemo.pojo.UserPojo;

/**
 * @author juaneins_uio
 *
 */
@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
	
	@Value("${value.name}")
	private String name;
	
	@Value("${value.lastname}")
	private String lastName;
	
	@Value("${value.random}")
	private String random;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(name, lastName);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		//dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.url(jdbcUrl);
		//dataSourceBuilder.username("sa");
		dataSourceBuilder.username(username);
		//dataSourceBuilder.password("");
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}
	
}

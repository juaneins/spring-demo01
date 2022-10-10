package com.fundamentos.springboot.springdemo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

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
import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.pojo.UserPojo;
import com.fundamentos.springboot.springdemo.repository.UserRepository;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(SpringApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public SpringDemoApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency,
			MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pastExecutions();
		saveUserInDatabase();
	}

	private void pastExecutions() {
		componentDependency.greeting();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		String result = myBeanWithProperties.function();
		System.out.println(result);
		System.out.println(userPojo.toString());
		logger.error("This is an error!!");
	}

	private void saveUserInDatabase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(1983, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(1983, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(1983, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(1983, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(1983, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(1983, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(1983, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(1983, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(1983, 4, 10));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9);
		// userRepository.saveAll(list);
		list.stream().forEach(userRepository::save);
	}
}
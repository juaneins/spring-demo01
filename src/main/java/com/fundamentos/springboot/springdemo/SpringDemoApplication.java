package com.fundamentos.springboot.springdemo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentos.springboot.springdemo.bean.MyBean;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithDependency;
import com.fundamentos.springboot.springdemo.bean.MyBeanWithProperties;
import com.fundamentos.springboot.springdemo.component.ComponentDependency;
import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.pojo.UserPojo;
import com.fundamentos.springboot.springdemo.repository.UserRepository;
import com.fundamentos.springboot.springdemo.service.UserService;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(SpringApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public SpringDemoApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency,
			MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo, UserRepository userRepository, UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pastExecutions();
		saveUserInDatabase();
		getInformationJpqlFromUser();
		saveWithErrorTransaction();
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
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(1980, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(1993, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(1978, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(1996, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(1999, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2000, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2001, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(1981, 4, 10));
		User user10 = new User("Karolina", "karolina@domain.com", LocalDate.of(1979, 11, 21));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9,user10);
		// userRepository.saveAll(list);
		list.stream().forEach(userRepository::save);
	}
	
	private void getInformationJpqlFromUser() {
		/*Optional<User> findUser = userRepository.findByEmail("paola@domain.com");
		logger.info("Found user by email: " + findUser.orElseThrow(()-> new RuntimeException("User not found")));*/
		logger.info(userRepository.findByEmail("paola@domain.com")
				.orElseThrow(() -> new RuntimeException("User not found")));
		userRepository.findAndSort("Mar", Sort.by("birthDate").ascending()).stream()
				.forEach(user -> logger.info("Usuario con metodo sort: " + user));
		
		userRepository.findByName("Karen").stream().forEach(user -> logger.info("Find by name user: " + user));
		userRepository.findByNameAndEmail("Karen", "karen2@domain.com").forEach(user -> logger.info("Find by email and name user: " + user));
		
		userRepository.findByNameLike("%n%")
		.stream()
		.forEach(user -> logger.info("findBynameLike: " + user));
		
		userRepository.findByNameOrEmail("Marisol","karolina@domain.com")
		.stream()
		.forEach(user -> logger.info("findByNameOrEmail: " + user));
		
		userRepository
				.findByBirthDateBetween(LocalDate.of(1978, Month.JANUARY, 6), LocalDate.of(1981, Month.DECEMBER, 31))
				.stream().forEach(user -> logger.info("findByBirthDateBetween: " + user));
		

		userRepository.findByNameLikeOrderByIdDesc("%s%")
		.stream()
		.forEach(user -> logger.info("findByNameLikeOrderByIdDesc: " + user));
		
		userRepository.findByNameContainingOrderByIdAsc("o")
		.stream()
		.forEach(user -> logger.info("findByNameContainingOrderByIdAsc: " + user));
		
		logger.info("getAllByBirthDateAndEmail: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(1978, 6, 18),"marisol@domain.com")
		.orElseThrow(() -> new RuntimeException("User not found ")));
	}
	
	private void saveWithErrorTransaction() {
		User user1 = new User("John Transaction1", "transaction1@domain.com", LocalDate.of(1983, 3, 13));
		User user2 = new User("Marco Transaction2", "transaction2@domain.com", LocalDate.of(1980, 12, 8));
		User user3 = new User("Daniela Transaction3", "transaction3@domain.com", LocalDate.of(1993, 9, 8));
		User user4 = new User("Daniela Transaction4", "transaction4@domain.com", LocalDate.of(2001, 5, 8));
		List<User> users = Arrays.asList(user1, user2, user3, user4);
		userService.saveTransactional(users);
		userService.getAllUsers().stream().forEach(user -> logger.info("Select new transactional users: " + user));
	}
}
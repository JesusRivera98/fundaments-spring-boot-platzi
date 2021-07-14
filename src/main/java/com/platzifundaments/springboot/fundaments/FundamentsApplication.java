package com.platzifundaments.springboot.fundaments;

import com.platzifundaments.springboot.fundaments.bean.MyBean;
import com.platzifundaments.springboot.fundaments.bean.MyBeanWithDependency;
import com.platzifundaments.springboot.fundaments.bean.MyBeanWithProperties;
import com.platzifundaments.springboot.fundaments.component.ComponentDependency;
import com.platzifundaments.springboot.fundaments.entity.Post;
import com.platzifundaments.springboot.fundaments.entity.User;
import com.platzifundaments.springboot.fundaments.pojo.UserPojo;
import com.platzifundaments.springboot.fundaments.repository.PostRepository;
import com.platzifundaments.springboot.fundaments.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(this.getClass());

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	//private PostRepository postRepository;

	public  FundamentsApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//previousExamples();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}
	private void getInformationJpqlFromUser(){
		LOGGER.info("User with method findByUserEmail" + userRepository.findByUserEmail("julie@domain.com")
		.orElseThrow(() -> new RuntimeException("Couldn't find the user")));

		userRepository.findByAndSort("test", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("User with sort method" + user));

		userRepository.findByName("Jhon")
			.stream()
			.forEach(user -> LOGGER.info("User with query method: " + user));

		LOGGER.info("User with query method findByEmailAndUser: " + userRepository.findUsersByEmailAndName("daniela@domain.com", "Daniela")
				.orElseThrow(() -> new RuntimeException("User not found")));

		userRepository.findByNameLike("%t%")
				.stream()
				.forEach(user -> LOGGER.info("User findByNameLike: " + user));
		userRepository.findByNameOrEmail(null, "Test1@domain.com")
				.stream()
				.forEach(user -> LOGGER.info("User findByNameOrEmail: " + user));

		userRepository
				.findByBirthDateBetween(LocalDate.of(2021,03,1), LocalDate.of(2021,4,2))
				.stream()
				.forEach(user -> LOGGER.info("User dates interval: " + user));

		userRepository.findByNameLikeOrderByIdDesc("%Test%")
				.stream()
				.forEach(user -> LOGGER.info("User found with like and ordered: " + user));

		userRepository.findByNameContainingOrderByIdDesc("Test")
				.stream()
				.forEach(user -> LOGGER.info("User found with containing and ordered: " + user));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 03, 15));
		User user2 = new User("Julie", "julie@domain.com", LocalDate.of(2021, 03, 20));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 03, 25));
		User user4 = new User("Oscar", "oscar@domain.com", LocalDate.now());
		User user5 = new User("Test1", "Test1@domain.com", LocalDate.now());
		User user6 = new User("Test2", "Test2@domain.com", LocalDate.now());
		User user7 = new User("Test3", "Test3@domain.com", LocalDate.now());
		User user8 = new User("Test4", "Test4@domain.com", LocalDate.now());
		User user9 = new User("Test5", "Test5@domain.com", LocalDate.now());
		User user10 = new User("Test6", "Test6@domain.com", LocalDate.now());
		User user11 = new User("Test7", "Test7@domain.com", LocalDate.now());
		User user12 = new User("Test8", "Test8@domain.com", LocalDate.now());
		User user13 = new User("Test9", "Test9@domain.com", LocalDate.now());
		List<User> list = Arrays.asList(user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13);
		list.stream().forEach(userRepository::save);
		//postRepository.save(new Post("Mi post test1", user12));
		//postRepository.save(new Post("Mi post test2", user13));
		//postRepository.save(new Post("Mi post test3", user13));
	}

	public void previousExamples(){
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		try {
			//Error
			int value = 10/0;
			LOGGER.debug("My value: " + value);
		}catch (Exception e){
			LOGGER.error("This is an error dividing by 0" + e.getMessage());
		}
	}
}

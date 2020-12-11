package com.jpa.jpaMysql;

import com.jpa.jpaMysql.dao.UserRespositry;
import com.jpa.jpaMysql.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaMysqlApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JpaMysqlApplication.class, args);

		UserRespositry userRespositry = context.getBean(UserRespositry.class);

//		User user = new User();
//		user.setName("Sonu Kumar");
//		user.setCity("Jalandhar");
//
//		User user1 = userRespositry.save(user);
//		System.out.println(user1);

		User user1 = new User();
		user1.setName("Ankit kr");
		user1.setCity("Lagma");

		User user2 = new User();
		user2.setName("Raman kr");
		user2.setCity("Khaira");


		User user3 = new User();
		user3.setName("Sanu kr");
		user3.setCity("Katuna");

		// add only one user at a time
		//User u = userRespositry.save(user1);
		//User u2 = userRespositry.save(user2);
		//System.out.println("Saved user : " + u + "and : " + u2);

		//*********************CREATE****************************
//		List<User> users = List.of(user1, user2, user3);
//		Iterable<User> result = userRespositry.saveAll(users);
//
//		System.out.println("All tuples saved to database are : ");
//		result.forEach(u ->{
//			System.out.println(u);
//		});


		//*********************READ*****************************

		System.out.println("Reading data...........");
		Iterable<User> itr = userRespositry.findAll();
		itr.forEach(u -> {
			System.out.println(u);
		});

		//********************UPDATE***************************

//		System.out.println("Updating the data");
//		Optional<User> optional = userRespositry.findById(3);
//		User user = optional.get();
//		user.setName("Niraj Kumar Mehta");
//		user.setCity("Los Angles");
//		User res = userRespositry.save(user);
//		System.out.println("Updated user is " + res);

		//***************************CUSTOM FINDER METHODS************************************
		//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
		System.out.println("Custom finder Methods");

		List<User> list = userRespositry.findByName("Ankit kr");
		list.forEach(l-> System.out.println(l));
		//NOTE: name and city values are not case sensitive
		List<User> list2 = userRespositry.findByNameAndCity("sanu kr", "katuna");
		list2.forEach(l-> System.out.println(l));

		System.out.println("findByNameLike Methods: Here % stands with any number of character");
		List<User> list3 = userRespositry.findByNameLike("%kit%");
		list3.forEach(l-> System.out.println(l));

		//***************************@Query and @Param with JPQL and Native**********************
		// @Query with JPQL
		System.out.println("@Query with JPQL");
		List<User> allUser = userRespositry.getAllUsers();
		allUser.forEach(u -> System.out.println(u));

		// @Query with JPQL as a PARAMETIRIZED QUERY
		System.out.println("@Query with JPQL as parameter variable");
		List<User> userName = userRespositry.getUserByName("Niraj Kumar Mehta", "Los Angles");
		userName.forEach(u -> System.out.println(u));


	}
}

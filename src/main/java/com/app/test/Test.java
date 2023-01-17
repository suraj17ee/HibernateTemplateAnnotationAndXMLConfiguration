package com.app.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.config.AppConfig;
import com.app.model.User;
import com.app.service.IUserService;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		IUserService u = (IUserService) ac.getBean("serviceUserImpl");
		
		//INSERT
		 User user = new User();
		 user.setUserId(17);
		 user.setUserName("Minakshi");
		 user.setUserCode("Uss138");
		 u.save(user);
		 System.out.println("Saved data successfully!!");
		 
		//UPDATE
//		 User user = new User();
//		 user.setUserId(5);
//		 user.setUserName("VickyRajkumar");
//		 user.setUserCode("psdf");
//		 u.update(user);
//		 System.out.println("update succesfull");
		 
		
		 //DELETE
//		 int id= 5;
//		 User user = new User(); 
//		 user.setUserId(id); 
//		 u.delete(id);
//		 System.out.println(id+" user deleted!!");
		 
		//FETCH ALL DATA
//		List<User> list = u.getAllUsers();
//		for (User user : list)
//			System.out.println(user);

		//FETCH ONE DATA
//		User user = u.getUserById(6);
//		System.out.println(user);
	}
}

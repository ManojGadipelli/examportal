package com.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class ExamserverApplicationTests {
//
//	@Test
//	void contextLoads() {
//		System.out.println("testing main");
//	}
//	
//	
//	
//
//}


import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@SpringBootTest
class ExamserverApplicationTests {
	
	
	@Autowired
	UserService userService;

	@Test
	public void testcreateUser() throws Exception {
		
		User user=new User();
		user.setFirstName("Shyam");
		user.setLastName("Pat");
		user.setUsername("shahpat");
		user.setPassword("abc");
		user.setEmail("ab@gmail.com");
		user.setProfile("default.png");
	
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();

		userRole.setRole(role1);

		userRole.setUser(user);

		userRoleSet.add(userRole);

		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
		
	}	
	/**void contextLoads() {
		System.out.println("testing main");
	}**/

}


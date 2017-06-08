package com.kdemo.jooq.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kdemo.jooq.domain.tables.pojos.Users;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:conf/appcontext-root.xml")
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testGetUsers() {
		List<Users> users = userService.getUsers();
		System.out.println(users);
	}
	
	@Test
	public void testInsert1() throws Exception {
		Users user = new Users(null, "sok", "F");
		int insert = userService.insert1(user);
		System.out.println(insert);
	}
	
	@Test
	public void testInsert2() throws Exception {
		Users user = new Users(null, "sok1", "F");
		user.setName("Sok");
		user.setGender("F");
		int insert = userService.insert2(user);
		System.out.println(insert);
	}
}

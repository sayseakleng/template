package com.kdemo.jooq.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdemo.jooq.domain.tables.pojos.User;
import com.kdemo.jooq.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/get")
	public List<User> testGetUsers() {
		List<User> users = userService.getUsers();
		return users;
	}
	
	@GetMapping("/insert1")
	public int insert1(){
		User user = new User(null, "sok1", "F");
		int insert = userService.insert1(user);
		return insert;
	}
	
	@GetMapping("/insert2")
	public int insert2() throws Exception {
		User user = new User(null, "sok2", "F");
		int insert = userService.insert2(user);
		return insert;
	}
}

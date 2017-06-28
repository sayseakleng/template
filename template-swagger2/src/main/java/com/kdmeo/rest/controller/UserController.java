package com.kdmeo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdmeo.rest.dto.User;
import com.kdmeo.rest.service.UserService;

import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("withMatrix/{id}")
	public List<User> getUserById(
			@ApiParam(hidden = true)
			@MatrixVariable(pathVar = "id") int userId,
			
			@ApiParam(value = "id;userId=1", defaultValue = "id;userId=%d")
			@PathVariable String id
		){
		
		return userService.getUsers();
	}
	
	@ApiIgnore
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping
	public Boolean save(@Validated @RequestBody User user) {
		return userService.save(user);
	}
		
	@PutMapping("/{userId}")
	public Boolean update(@Validated @RequestBody User user, @PathVariable int userId) {
		user.setId(userId);
		return userService.update(user);
	}
}

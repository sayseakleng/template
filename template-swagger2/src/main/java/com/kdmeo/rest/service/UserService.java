package com.kdmeo.rest.service;

import java.util.List;

import com.kdmeo.rest.dto.User;

public interface UserService {
	boolean save(User user);
	boolean update(User user);
	boolean delete(int userId);
	List<User> getUsers();
	User getUserById(int userId);
}

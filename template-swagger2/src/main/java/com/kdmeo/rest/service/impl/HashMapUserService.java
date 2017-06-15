package com.kdmeo.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kdmeo.rest.dto.User;
import com.kdmeo.rest.service.UserService;

@Service
public class HashMapUserService implements UserService {
	private Map<Integer, User> userMap = new HashMap<>();

	@Override
	public boolean save(User user) {
		userMap.put(user.getId(), user);
		return  true;
	}

	@Override
	public boolean update(User user) {
		userMap.put(user.getId(), user);
		return true;
	}

	@Override
	public boolean delete(int userId) {
		userMap.remove(userId);
		return true;
	}

	@Override
	public List<User> getUsers() {
		return new ArrayList<>(userMap.values());
	}

	@Override
	public User getUserById(int userId) {
		return userMap.get(userId);
	}
}

package com.kdemo.jooq.dao;

import java.util.List;

import com.kdemo.jooq.domain.tables.pojos.User;


public interface UserDAO {
	
	List<User> getUsers();
	
	int insert(User user);
	
}

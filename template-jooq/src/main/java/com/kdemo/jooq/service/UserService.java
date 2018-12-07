package com.kdemo.jooq.service;

import java.util.List;

import com.kdemo.jooq.domain.tables.pojos.User;


public interface UserService {
	
	List<User> getUsers();
	
	int insert1(User user);
	
	int insert2(User user) throws Exception;

}

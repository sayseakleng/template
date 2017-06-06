package com.kdemo.jooq.service;

import java.util.List;

import com.kdemo.jooq.domain.tables.pojos.Users;


public interface UserService {
	
	List<Users> getUsers();
	
	int insert1(Users user);
	
	int insert2(Users user) throws Exception;

}

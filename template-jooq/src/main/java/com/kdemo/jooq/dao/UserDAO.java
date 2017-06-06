package com.kdemo.jooq.dao;

import java.util.List;

import com.kdemo.jooq.domain.tables.pojos.Users;

public interface UserDAO {
	
	List<Users> getUsers();
	
	int insert(Users user);
	
}

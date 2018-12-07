package com.kdemo.jooq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdemo.jooq.dao.UserDAO;
import com.kdemo.jooq.domain.tables.daos.UserDao;
import com.kdemo.jooq.domain.tables.pojos.User;
import com.kdemo.jooq.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public int insert1(User user) {
		// option 1
		dao.insert(user);
		return 1;
		
		// option 2
		/*int insert = userDAO.insert(user);
		return insert;*/
	}
	
	@Override
	public int insert2(User user) throws Exception {
		int insert = userDAO.insert(user);
		
		if(insert > 0) {
			throw new Exception("Not allow to insert");
		}

		return insert;
	}

}

package com.kdemo.jooq.dao.impl;

import static com.kdemo.jooq.domain.Tables.USERS;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kdemo.jooq.dao.UserDAO;
import com.kdemo.jooq.domain.tables.pojos.Users;
import com.kdemo.jooq.domain.tables.records.UsersRecord;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private DSLContext dsl;
	

	@Override
	public List<Users> getUsers() {
			return dsl
				.select(USERS.fields())
				.from(USERS)
				.fetchInto(Users.class);
	}

	@Override
	public int insert(Users user) {
		
		// option 1 : with fetch auto ID
		UsersRecord newRecord = dsl.newRecord(USERS, user);
		int store = newRecord.store();
		if(store > 0) {
			user.setId(newRecord.getId());
		}
		return store;
		
		// Otion 2
/*		return dsl.insertInto(USERS, USERS.NAME, USERS.GENDER)
			.values(user.getName(), user.getGender())
			.execute();*/
		
	}

}

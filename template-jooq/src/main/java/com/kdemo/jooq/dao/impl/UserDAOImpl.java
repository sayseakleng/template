package com.kdemo.jooq.dao.impl;

import static com.kdemo.jooq.domain.Tables.USER;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kdemo.jooq.dao.UserDAO;
import com.kdemo.jooq.domain.tables.pojos.User;
import com.kdemo.jooq.domain.tables.records.UserRecord;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private DSLContext dsl;
	

	@Override
	public List<User> getUsers() {
			return dsl
				.select(USER.fields())
				.from(USER)
				.fetchInto(User.class);
	}

	@Override
	public int insert(User user) {
		
		// option 1 : with fetch auto ID
		UserRecord newRecord = dsl.newRecord(USER, user);
		int store = newRecord.insert();
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

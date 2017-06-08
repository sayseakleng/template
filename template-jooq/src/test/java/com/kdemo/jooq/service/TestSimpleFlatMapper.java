package com.kdemo.jooq.service;

import static com.kdemo.jooq.domain.Tables.USERS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jooq.impl.DefaultDSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.simpleflatmapper.jdbc.DynamicJdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.simpleflatmapper.jooq.SfmRecordMapperProvider;
import org.simpleflatmapper.jooq.SfmRecordMapperProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kdemo.jooq.dto.UserDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:conf/appcontext-root.xml")
public class TestSimpleFlatMapper {

	@Autowired
	private DefaultDSLContext dsl;
	
	
	@Test
	public void test() throws SQLException {

		ResultSet fetchResultSet = dsl
				.select(USERS.ID, USERS.NAME, USERS.GENDER.as("infos_gender"))
				.from(USERS)
				.fetchResultSet();

		DynamicJdbcMapper<UserDTO> mapper = JdbcMapperFactory.newInstance()
				.addKeys("name")
				.ignorePropertyNotFound()
				.newMapper(UserDTO.class);
		
		//List<UserDTO> users = new ArrayList<>();
		
		try (ResultSet rs = fetchResultSet) {
		    mapper.stream(rs).forEach(System.out::println);
		    //mapper.stream(rs).forEach(users::add);
		}
	}
	
	// https://github.com/arnaudroger/SimpleFlatMapper/wiki/SFM-Integration-in-Jooq
	// it can't use .addKeys("name")
	@Test
	public void test2() {
		
		SfmRecordMapperProvider newProvider = SfmRecordMapperProviderFactory.newInstance().newProvider();
		newProvider = SfmRecordMapperProviderFactory.newInstance()
				.ignorePropertyNotFound()
				.newProvider();
		//dsl.configuration().set(new SfmRecordMapperProvider());
		dsl.configuration().set(newProvider);
		
		List<UserDTO> fetchInto = dsl
				.select(USERS.ID, USERS.NAME, USERS.GENDER.as("infos_gender"))
				.from(USERS)
				.fetchInto(UserDTO.class);
		

		
		for (UserDTO userDTO : fetchInto) {
			System.out.println(userDTO);
		}
	}

}

package com.tbentsen.training.db;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.tbentsen.training.domain.User;

public class UserDao {

	static final Map<Long, User> MY_MAP = ImmutableMap.of(
	        1L, new User(1L,"Jette"),
	        2L, new User(2L,"Nanna"),
	        3L, new User(3L,"Jacob")
	);
	
	
	
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static User getUser(Long id) {
		return MY_MAP.get(id); 
	}

}

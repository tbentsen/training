package com.tbentsen.training.domain;

public class User {
	
	Long id;
	
	String name;

	public User(Long i, String name) {
		this.id = i;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}

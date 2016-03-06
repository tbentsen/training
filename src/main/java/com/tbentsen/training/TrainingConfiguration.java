package com.tbentsen.training;

import io.dropwizard.Configuration;

public class TrainingConfiguration extends Configuration {
	
	String displayName;
	
	String dbName;

	public String getDisplayName() {
		return displayName;
	}

	public String getDbName() {
		return dbName;
	}
	
}

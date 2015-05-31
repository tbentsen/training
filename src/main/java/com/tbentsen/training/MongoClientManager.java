package com.tbentsen.training;
import io.dropwizard.lifecycle.Managed;

import com.mongodb.MongoClient;

public class MongoClientManager implements Managed {
    private final MongoClient mongoClient;

    public MongoClientManager(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
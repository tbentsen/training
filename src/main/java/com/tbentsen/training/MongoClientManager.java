package com.tbentsen.training;

import io.dropwizard.lifecycle.Managed;

import com.mongodb.MongoClient;

public class MongoClientManager implements Managed {
    private final MongoClient mongoClient;

    public MongoClientManager(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

	public void start() throws Exception {
	}

	public void stop() throws Exception {
        mongoClient.close();
	}

}
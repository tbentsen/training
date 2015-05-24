package com.tbentsen.training;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.tbentsen.training.resources.TrainingResource;


public class TrainingApplication extends Application<TrainingConfiguration> {
    public static void main(String[] args) throws Exception {
        new TrainingApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

	@Override
	public void initialize(Bootstrap<TrainingConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/html","/"));
		
	}

	@Override
	public void run(TrainingConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub
		//environment.jersey().disable();
		//environment.jersey().setUrlPattern("/service/*");
		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("training");
		TrainingResource trainingResource = new TrainingResource(database);
		environment.jersey().register(trainingResource);
	}
	
}
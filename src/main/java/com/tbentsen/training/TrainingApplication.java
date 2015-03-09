package com.tbentsen.training;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.tbentsen.training.db.TrainingSessionDao;
import com.tbentsen.training.db.UserDao;
import com.tbentsen.training.resources.TrainingResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.servlets.assets.AssetServlet;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


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
		AssetsBundle assetsBundle = new AssetsBundle("/html","/");
		bootstrap.addBundle(assetsBundle);
		
	}

	@Override
	public void run(TrainingConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub
		//environment.jersey().disable();
		environment.jersey().setUrlPattern("/service/*");
		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("training");
		TrainingResource trainingResource = new TrainingResource(database);
		environment.jersey().register(trainingResource);
	}
	
}
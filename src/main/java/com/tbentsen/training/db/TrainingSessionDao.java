package com.tbentsen.training.db;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.tbentsen.training.domain.TrainingSessionEntity;

public class TrainingSessionDao extends BasicDAO<TrainingSessionEntity, ObjectId>{

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingSessionDao.class);

	private Datastore datastore;

	public TrainingSessionDao(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}
	
	

}

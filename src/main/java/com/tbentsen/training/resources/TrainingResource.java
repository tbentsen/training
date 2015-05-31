package com.tbentsen.training.resources;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.tbentsen.training.domain.TrainingSession;
import com.tbentsen.training.domain.User;

@Path("/training")
@Produces(MediaType.APPLICATION_JSON)

public class TrainingResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingResource.class);

    private Datastore datastore;

    public TrainingResource(final MongoClient mongoClient) {
    	this.datastore = new Morphia().createDatastore(mongoClient, "training");
	}

//	private final AtomicLong counter;
//    UserDao userDao;
//    TrainingSessionDao trainingSessionDao;
//
//    public TrainingResource(TrainingSessionDao trainingSessionDao, UserDao userDao) {
//        this.counter = new AtomicLong();
//        this.trainingSessionDao = trainingSessionDao;
//        this.userDao = userDao;
//    }

    
    @POST
    @Path("/user/{id}/session")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSession(@PathParam("id") long userId, TrainingSession session) {
    	LOGGER.debug("saveSession: ");
    	session.setUserId(userId);
    	datastore.save(session);
    	
    	return Response.created(URI.create(session.getId().toString())).entity(session).build();
    }
//    @GET
//    @Timed
//    @Path("/user/{id}")
//    public User getUser(@PathParam("id") Optional<Long> userId) {
//    	counter.incrementAndGet();
//    	return new User(1L, "d");
//    	if (userId.isPresent()) {
//    		return userDao.getUser(userId.get());
//    	} else {
//    		return userDao.getUser(1L);
//    	}
//    }
    
    @GET
    @Timed
    public User getDyt() {
    	//counter.incrementAndGet();
    	return new User(1L, "d");
//    	if (userId.isPresent()) {
//    		return userDao.getUser(userId.get());
//    	} else {
//    		return userDao.getUser(1L);
//    	}
    }

    
//    @GET
//    @Timed
//    @Path("/user/{id}/sessions")
//    public List<TrainingSession> getTrainingSessions(@PathParam("id") Optional<Long> userId) {
//    	counter.incrementAndGet();
//    	return trainingSessionDao.getTrainingSessions(userId.get());
//    }
    
}
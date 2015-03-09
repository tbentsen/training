package com.tbentsen.training.resources;

import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.codahale.metrics.annotation.Timed;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.tbentsen.training.db.TrainingSessionDao;
import com.tbentsen.training.db.UserDao;
import com.tbentsen.training.domain.TrainingSession;
import com.tbentsen.training.domain.User;

@Path("/training")
@Produces(MediaType.APPLICATION_JSON)
public class TrainingResource {
	private final DB database;
	
    public TrainingResource(DB database) {
		super();
		this.database = database;
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
    	session.setUserId(userId);
    	
    	DBCollection sessions = database.getCollection("sessions");
    	JacksonDBCollection<TrainingSession,String> collection = JacksonDBCollection.wrap(sessions, TrainingSession.class, String.class);
    	WriteResult<TrainingSession,String> writeResult = collection.insert(session);
    	if (writeResult == null) {
    		return Response.serverError().build();
    	}
    	session.setId(writeResult.getSavedId());
    	
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
package com.tbentsen.training.resources;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.MongoClient;
import com.tbentsen.training.db.TrainingSessionDao;
import com.tbentsen.training.domain.TrainingCategoryEntity;
import com.tbentsen.training.domain.TrainingSessionEntity;
import com.tbentsen.training.domain.UserEntity;

@Path("/training")
@Produces(MediaType.APPLICATION_JSON)

public class TrainingResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingResource.class);

    private TrainingSessionDao trainingSessionDao;

    public TrainingResource(TrainingSessionDao trainingSessionDao) {
		this.trainingSessionDao = trainingSessionDao;
	}

	@POST
    @Path("/user/{id}/session")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSession(@PathParam("id") long userId, TrainingSessionEntity session) {
    	session.setUserId(userId);
    	trainingSessionDao.save(session);
    	
    	return Response.created(URI.create(session.getId().toString())).entity(session).build();
    }
    
    @GET
    @Timed
    public UserEntity getDyt() {
    	return new UserEntity(1L, "d");
    }
    
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        MongoClient mongoClient = new MongoClient();
        Datastore datastore = null;
        datastore = new Morphia().createDatastore(mongoClient, "training");
        
        TrainingSessionEntity trainingSession = new TrainingSessionEntity();
        trainingSession.setTrainingCatagory(new TrainingCategoryEntity("Cycling"));
        trainingSession.setStart(new DateTime());
        trainingSession.setUserId(1L);
       	datastore.save(trainingSession);

       	//ObjectMapper mapper = new ObjectMapper();
       	//Map<String,Object> user = mapper.readValue(new File("c:\\user.json"), Map.class);
       	
    }
}
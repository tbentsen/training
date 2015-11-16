package com.tbentsen.training.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.mongodb.MongoClient;
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

    @POST
    @Path("/user/{id}/session")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSession(@PathParam("id") long userId, TrainingSession session) {
    	session.setUserId(userId);
    	datastore.save(session);
    	
    	return Response.created(URI.create(session.getId().toString())).entity(session).build();
    }
    
    @GET
    @Timed
    public User getDyt() {
    	return new User(1L, "d");
    }   
}
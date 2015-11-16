package com.tbentsen.training.db;

import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.ImmutableList;
import com.tbentsen.training.domain.TrainingCategory;
import com.tbentsen.training.domain.TrainingSession;

public class TrainingSessionDao {

	static final List<TrainingSession> SESSION_LIST = ImmutableList.of(
	        new TrainingSession(UserDao.getUser(1L).getId(),new TrainingCategory("Cycling"),new DateTime("2015-01-13T21:00:00"),new DateTime("2015-01-13T22:00:00")),
	        new TrainingSession(UserDao.getUser(1L).getId(),new TrainingCategory("Cycling"),new DateTime("2015-01-15T21:00:00"),new DateTime("2015-01-15T22:00:00")),
	        new TrainingSession(UserDao.getUser(1L).getId(),new TrainingCategory("Cycling"),new DateTime("2015-01-17T21:00:00"),new DateTime("2015-01-17T22:00:00"))
	);
	
	
	
	public TrainingSessionDao() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<TrainingSession> getTrainingSessions(Long id) {
		return SESSION_LIST; 
	}
	
}

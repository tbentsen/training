package com.tbentsen.training.domain;

import org.joda.time.DateTime;
import org.mongojack.Id;
import org.mongojack.ObjectId;

public class TrainingSession {
	
	@ObjectId
	@Id
	String id;
	
	Long userId;
	
	TrainingCategory trainingCategory;
	
	//@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	DateTime start;
	
	//@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	DateTime end;

	public TrainingSession(Long userId, TrainingCategory trainingCatagory, DateTime start, DateTime end) {
		this.userId = userId;
		this.trainingCategory = trainingCatagory;
		this.start = start;
		this.end = end;
	}

	public TrainingCategory getTrainingCatagory() {
		return trainingCategory;
	}

	public void setTrainingCatagory(TrainingCategory trainingCatagory) {
		this.trainingCategory = trainingCatagory;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public TrainingCategory getTrainingCategory() {
		return trainingCategory;
	}

	public void setTrainingCategory(TrainingCategory trainingCategory) {
		this.trainingCategory = trainingCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}

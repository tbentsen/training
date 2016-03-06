package com.tbentsen.training.domain;

import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Converters;
import org.mongodb.morphia.annotations.Entity;

import com.tbentsen.training.util.JodaDateTimeConverter;

@Entity
@Converters(JodaDateTimeConverter.class)
public class TrainingSessionEntity extends BaseEntity {
	
	Long userId;
	
	TrainingCategoryEntity trainingCategory;
	
	DateTime start;
	
	//DateTime end;
	
	public TrainingSessionEntity() {
	}

	public TrainingSessionEntity(Long userId, TrainingCategoryEntity trainingCatagory, DateTime start, DateTime end) {
		this.userId = userId;
		this.trainingCategory = trainingCatagory;
		this.start = start;
		//this.end = end;
	}
	
	public TrainingSessionEntity(Long userId, TrainingCategoryEntity trainingCatagory, DateTime start) {
		this.userId = userId;
		this.trainingCategory = trainingCatagory;
		this.start = start;
	}

	public TrainingCategoryEntity getTrainingCatagory() {
		return trainingCategory;
	}

	public void setTrainingCatagory(TrainingCategoryEntity trainingCatagory) {
		this.trainingCategory = trainingCatagory;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

//	public DateTime getEnd() {
//		return end;
//	}
//
//	public void setEnd(DateTime end) {
//		this.end = end;
//	}

	public TrainingCategoryEntity getTrainingCategory() {
		return trainingCategory;
	}

	public void setTrainingCategory(TrainingCategoryEntity trainingCategory) {
		this.trainingCategory = trainingCategory;
	}


	public String getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}

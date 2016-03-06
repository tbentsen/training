package com.tbentsen.training.domain;

public class TrainingCategoryEntity {
	
	private String name;

    public TrainingCategoryEntity() {	}

	public TrainingCategoryEntity(String name) {
            this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

}

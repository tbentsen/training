package com.tbentsen.training.domain;

public enum TrainingCategory {
	RUNNING(1), WALKING(2), CYCLING(3);
    
	private int value;

    private TrainingCategory(int value) {
            this.value = value;
    }

}

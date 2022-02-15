package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;


public abstract class TrainingCentre {

    private int limit = 0;
    private int currentCapacity = 0;
    private ArrayList<Trainee> trainees;
    private Course courseType;

    /// Methods inherited

    abstract boolean shouldClose();

    public boolean isCentreFull() {
        return (currentCapacity == limit);
    }

    public void addAllTrainees(List<Trainee> waitingList) {
        trainees.addAll(waitingList);
        this.currentCapacity = trainees.size();
    }

    public int getEmptySpace() {
        return limit - currentCapacity;
    }

    /// Getters and Setters

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(ArrayList<Trainee> trainees) {
        this.trainees = trainees;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCourseType(Course courseType) {
        this.courseType = courseType;
    }

    public Course getCourseType() {
        return courseType;
    }
}

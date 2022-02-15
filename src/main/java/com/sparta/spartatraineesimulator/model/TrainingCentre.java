package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;


public abstract class TrainingCentre {

    private int limit = 0;
    private int currentCapacity = 0;
    private ArrayList<Trainee> trainees;
    private String name;

    /// Constructor

    public TrainingCentre() {
    }

    /// Methods inherited

    abstract boolean shouldClose();

    public boolean isCentreFull() {
        return (currentCapacity == limit);
    }

    public void addAllTrainees(List<Trainee> waitingList) {
        for (Trainee t : waitingList){
            t.setIsWaiting(false);
        }
        trainees.addAll(waitingList);
        this.currentCapacity = trainees.size();
    }

    public int getEmptySpace() {
        return limit - currentCapacity;
    }

    /// Getters and Setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "TrainingCentre{" +
                "limit=" + limit +
                ", currentCapacity=" + currentCapacity +
                ", trainees=" + trainees +
                '}';
    }
}

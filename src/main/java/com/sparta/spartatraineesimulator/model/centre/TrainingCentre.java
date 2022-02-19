package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;

import java.util.ArrayList;
import java.util.List;


public abstract class TrainingCentre {

    private int limit = 0;
    private int currentCapacity = 0;
    private int activeTime = 0;
    private ArrayList<Trainee> trainees;

    private Course courseType;
    private String name;

    private int id;

/// Methods inherited


    public TrainingCentre(int id) {
        this.id = id;
    }

    public abstract boolean shouldClose();

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

    public void removeTrainees() {
        this.trainees = null;
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

    public void setCourseType(Course courseType) {
        this.courseType = courseType;
    }

    public Course getCourseType() {
        return courseType;
    }

    public boolean hasCourse() {
        if (courseType != Course.NONE) {
            return true;
        }
        return false;
    }

    public void removeCollectionTrainees(ArrayList<Trainee> traineesCollection) {
        this.trainees.removeAll(traineesCollection);
        this.currentCapacity = this.trainees.size();
    }


    @Override
    public String toString() {
        return "TrainingCentre{" +
                "limit=" + limit +
                ", currentCapacity=" + currentCapacity +
                ", trainees=" + trainees +
                '}';
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public void incrementActiveTime(){
        activeTime++;
    }

    public int getId() {
        return id;
    }
}

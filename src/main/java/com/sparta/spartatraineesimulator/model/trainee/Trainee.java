package com.sparta.spartatraineesimulator.model.trainee;

import com.sparta.spartatraineesimulator.model.Course;

public class Trainee {

    private int traineeId;
    private int trainingTime = 0;

    private boolean isWaiting = true;
    private final Course courseType = Course.randomCourseType(); //random course for a trainee

    public Trainee(int traineeId, int trainingTime){
        this.traineeId = traineeId;
        this.trainingTime = trainingTime;
    }

    public void incrementTrainingTime(){
        trainingTime++;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    //setter for the waiting
    public void setIsWaiting(boolean isWaiting) {
        this.isWaiting = isWaiting;
    }

    //getter for the waiting
    public boolean isWaiting() {
        return isWaiting;
    }

    //getter for the trainee's course type
    public Course getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "\nTrainee:\n" +
                "Trainee ID = " + traineeId +
                "\nTraining time = " + trainingTime +
                "\nIs waiting? = " + isWaiting +
                "\nCourse = " + courseType;
    }
}

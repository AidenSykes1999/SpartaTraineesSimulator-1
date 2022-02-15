package com.sparta.spartatraineesimulator.model;

public class Trainee {

    private int traineeId;
    private int trainingTime = 0;

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

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                '}';
    }

    //getter for the trainee's course type
    public Course getCourseType() {
        return courseType;
    }
}

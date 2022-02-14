package com.sparta.spartatraineesimulator.model;

public class Trainee {
    private int traineeId;
    private int trainingTime = 0;

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

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                '}';
    }
}

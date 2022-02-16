package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class Client {
    private int clientId;
    private Course traineeTypeRequirement;
    private int traineeNumberRequirement;
    private ArrayList<Trainee> trainees = new ArrayList<>();
    boolean isHappy;
    int months;

    public Client(int clientId, Course traineeTypeRequirement, int traineeRequirement){
        this.clientId = clientId;
        this.traineeTypeRequirement = traineeTypeRequirement;
        this.traineeNumberRequirement = traineeRequirement;
        this.months = 0;
    }

    public int getClientId() {
        return clientId;
    }

    public Course getTraineeTypeRequirement() {
        return traineeTypeRequirement;
    }

    public int getTraineeNumberRequirement() {
        return traineeNumberRequirement;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Trainee trainee){
        trainees.add(trainee);
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public int getMonths() {
        return months;
    }

    public void incrementMonths(){
        months++;
    }

    public void resetMonths(){
        months = 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", traineeTypeRequirement=" + traineeTypeRequirement +
                ", traineeNumberRequirement=" + traineeNumberRequirement +
                ", trainees=" + trainees +
                ", isHappy=" + isHappy +
                ", months=" + months +
                '}';
    }
}

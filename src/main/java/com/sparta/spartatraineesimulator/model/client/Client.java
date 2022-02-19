package com.sparta.spartatraineesimulator.model.client;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private int clientId;
    private Course traineeTypeRequirement;
    private int traineeNumberRequirement;

    private ArrayList<Trainee> trainees = new ArrayList<>();
    private boolean isHappy;
    private int months;
    private int happyMonths = 0;

    public Client(int clientId, Course traineeTypeRequirement, int traineeRequirement){
        this.clientId = clientId;
        this.traineeTypeRequirement = traineeTypeRequirement;
        this.traineeNumberRequirement = traineeRequirement;
        this.months = 1;
        this.isHappy = false;
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

    public void setTrainees(List<Trainee> traineeList){
        trainees.addAll(traineeList);
    }

    public void incrementMonths(){
        months++;
    }

    public void resetMonths(){
        months = 1;
    }

    public void resetTrainees() {
        this.trainees = new ArrayList<>();
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public int getHappyMonths() {
        return happyMonths;
    }

    public void setHappyMonths(int happyMonths) {
        this.happyMonths = happyMonths;
    }

    public void incrementHappyMonths(){
        this.happyMonths++;
    }

    public void determineHappiness(){
        if (this.isHappy) {
            return;
        }
        if (this.months <= 12 && this.trainees.size() == this.traineeNumberRequirement){
            this.isHappy = true;
        }
        else {
            this.isHappy = false;
        }
    }

    public boolean isUnhappy(){
        if (this.months > 12) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", traineeTypeRequirement=" + traineeTypeRequirement +
                ", traineeNumberRequirement=" + traineeNumberRequirement +
                ", trainees=" + trainees +
                ", months=" + months +
                '}';
    }

}

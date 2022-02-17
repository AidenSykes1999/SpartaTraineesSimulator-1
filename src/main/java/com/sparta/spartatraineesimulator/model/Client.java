package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

    private int clientId;
    private Course courseRequirement;

    private int currentCapacity = 0;
    private int traineeNumberRequirement;
    private ArrayList<Trainee> trainees;
    int months;

    public Client(int clientId){

        Random r = new Random();

        this.clientId = clientId;
        this.courseRequirement = Course.randomCourseType();

        this.traineeNumberRequirement = r.nextInt(15, 51);
        this.trainees = new ArrayList<>(traineeNumberRequirement);

        this.months = 0;

    }

    public Course getCourseRequirement() {
        return courseRequirement;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", courseRequirement=" + courseRequirement +
                ", traineeNumberRequirement=" + traineeNumberRequirement +
                ", trainees=" + trainees +
                ", months=" + months +
                '}';
    }

    public int getEmptySpace() {
        return traineeNumberRequirement - currentCapacity;
    }

    public boolean isFull() {
        return (currentCapacity == traineeNumberRequirement);
    }

    public void addAllTrainees(List<Trainee> traineeList) {
        for (Trainee t : traineeList){
            t.setIsWaiting(false);
        }

        trainees.addAll(traineeList);
        currentCapacity = trainees.size();
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getTraineeNumberRequirement() {
        return traineeNumberRequirement;
    }
}

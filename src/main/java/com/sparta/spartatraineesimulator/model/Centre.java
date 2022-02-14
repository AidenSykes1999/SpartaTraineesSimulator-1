package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class Centre {

    private ArrayList<Trainee> trainees;
    private static final int LIMIT = 100;
    private int currentCapacity = 0;

    public Centre(ArrayList<Trainee> trainees) {
        this.trainees = trainees;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(ArrayList<Trainee> trainees) {
        this.trainees = trainees;
    }

}

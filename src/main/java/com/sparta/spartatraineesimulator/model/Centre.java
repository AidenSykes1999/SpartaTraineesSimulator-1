package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;

public class Centre {

    private ArrayList<Trainee> trainees;
    private static final int LIMIT = 100;
    private int currentCapacity = 0;

    public Centre() {
        this.trainees = new ArrayList<>(LIMIT);
    }

    public boolean isCentreFull() {
        return (currentCapacity == 100);
    }

    public int getEmptySpace() {
        return LIMIT - currentCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void addAllTrainees(List<Trainee> waitingList) {
        trainees.addAll(waitingList);
        this.currentCapacity = trainees.size();
    }
}

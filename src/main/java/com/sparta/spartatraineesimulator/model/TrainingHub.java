package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TrainingHub extends TrainingCentre {

    public TrainingHub() {
        super();
        setLimit(100);
        this.setTrainees(new ArrayList<>(getLimit()));
    }

    @Override
    public boolean shouldClose() {
        if (getCurrentCapacity() < 25){
            return true;
        } else { return false; }

    }

    @Override
    public String toString() {
        return "TrainingHub:\n" +
                "Current capacity = " + super.getCurrentCapacity() +
                "\nLimit = " + super.getLimit() +
                "\nEmpty Space = " + super.getEmptySpace() +
                "\nTrainees = " + super.getTrainees() + "\n\n";
    }
}

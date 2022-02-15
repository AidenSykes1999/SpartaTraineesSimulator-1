package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TrainingHub extends AbstractCentre{

    public TrainingHub() {

        super();
        setLimit(500);
        this.setTrainees(new ArrayList<>(getLimit()));

    }

    @Override
    boolean shouldClose() {
        if (getCurrentCapacity() < 25){
            return true;
        } else { return false; }

    }

}

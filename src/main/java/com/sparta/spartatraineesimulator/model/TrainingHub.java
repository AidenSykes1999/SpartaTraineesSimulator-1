package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TrainingHub extends TrainingCentre {

    public TrainingHub() {
        super();
        setLimit(100);
        this.setTrainees(new ArrayList<>(getLimit()));
        this.setName("Training Hub");
    }

    @Override
    public boolean shouldClose() {
        if (getCurrentCapacity() < 25){
            return true;
        } else { return false; }

    }

}

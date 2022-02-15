package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TechCentre extends TrainingCentre {

    public TechCentre() {
        super();
        setLimit(200);
        this.setTrainees(new ArrayList<>(getLimit()));
    }

    @Override
    public boolean shouldClose() {

        if (getCurrentCapacity() < 25){
            return true;
        } else { return false; }

    }

}

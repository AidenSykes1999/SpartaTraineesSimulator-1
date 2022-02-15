package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class BootCamp extends AbstractCentre{

    private int numMonthsInactive = 0;


    public BootCamp() {

        super();
        setLimit(500);
        this.setTrainees(new ArrayList<>(getLimit()));

    }

    @Override
    boolean shouldClose() {

        if (getCurrentCapacity() < 25){

            numMonthsInactive++;

        }
        // If number of months inactive is more than 3

        if (numMonthsInactive >= 3){
            return true;
        }

        return false;
    }
}

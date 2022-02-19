package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.Course;

import java.util.ArrayList;

public class BootCamp extends TrainingCentre {

    private int numMonthsInactive = 0;

    public BootCamp(int id) {
        super(id);
        setLimit(500);
        this.setTrainees(new ArrayList<>(getLimit()));
        this.setCourseType(Course.NONE);
        this.setName("Bootcamp");
    }

    @Override
    public boolean shouldClose() {

        if (getCurrentCapacity() < 25){
            numMonthsInactive++;
        }
        // If number of months inactive is more than 3

        if (numMonthsInactive >= 3){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BootCamp:\n" +
                "Current capacity = " + super.getCurrentCapacity() +
                "\nLimit = " + super.getLimit() +
                "\nEmpty Space = " + super.getEmptySpace() +
                "\nTrainees = " + super.getTrainees() + "\n\n";
    }
}

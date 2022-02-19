package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.Course;

import java.util.ArrayList;

public class TrainingHub extends TrainingCentre {

    public TrainingHub(int id) {
        super(id);
        setLimit(100);
        this.setTrainees(new ArrayList<>(getLimit()));
        this.setCourseType(Course.NONE);
        this.setName("Training Hub");
        this.setActiveTime(0);
    }

    @Override
    public boolean shouldClose() {
        if (getCurrentCapacity() < 25 && getActiveTime() > 0){
            return true;
        } else {incrementActiveTime(); return false; }

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

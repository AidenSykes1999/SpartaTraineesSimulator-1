package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TechCentre extends TrainingCentre {

    private final Course centreCourse = Course.randomCourseType();


    public TechCentre() {
        super();
        setLimit(200);
        this.setTrainees(new ArrayList<>(getLimit()));
        this.setName("Tech Centre");
        this.setTimeOpen(0);
    }

    public Course getCourseType() {
        return centreCourse;
    }

    @Override
    public boolean shouldClose() {

        if (getCurrentCapacity() < 25 && getTimeOpen() > 0){
            return true;
        } else {incrementActiveTime(); return false; }

    }

    @Override
    public String toString() {
        return "TechCentre:\n" +
                "Current capacity = " + super.getCurrentCapacity() +
                "\nLimit = " + super.getLimit() +
                "\nEmpty Space = " + super.getEmptySpace() +
                "\nTrainees = " + super.getTrainees() + "\n\n";
    }
}

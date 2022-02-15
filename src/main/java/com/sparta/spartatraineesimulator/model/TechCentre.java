package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class TechCentre extends TrainingCentre {

    private final Course centreCourse = Course.randomCourseType();

    public TechCentre() {
        super();
        setLimit(200);
        this.setTrainees(new ArrayList<>(getLimit()));
    }

    public Course getCourseType() {
        return centreCourse;
    }

    @Override
    public boolean shouldClose() {

        if (getCurrentCapacity() < 25){
            return true;
        } else { return false; }

    }

}

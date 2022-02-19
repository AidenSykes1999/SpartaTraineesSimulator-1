package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.Course;

import java.util.ArrayList;

public class TechCentre extends TrainingCentre {

    private final Course centreCourse = Course.randomCourseType();

    public TechCentre(int id) {
        super(id);
        setLimit(200);
        this.setTrainees(new ArrayList<>(getLimit()));
        this.setName("Tech Centre");
        this.setActiveTime(0);
    }

    public Course getCourseType() {
        return centreCourse;
    }

    @Override
    public boolean shouldClose() {

        if (getCurrentCapacity() < 25 && getActiveTime() > 0){
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

package com.sparta.spartatraineesimulator.model;

import java.util.List;

public enum Courses { //courses in the academy
    JAVA,
    C_SHARP,
    DATA,
    DEVOPS,
    BUSINESS;

    private static final List<Courses> VALUES = List.of(values()); //using generalised list to store the enums in it
    private static final int COURSES_SIZE = VALUES.size(); //size of the courses list- a constant
    private static final ProjectRandomGenerator projectRandomGenerator =
            new ProjectRandomGenerator(1234567891234567891L); //using a long seed (will also test it later)

    public String getCourses() { //will use this in testing
        return switch (this) {
            case JAVA -> "Java";
            case C_SHARP -> "C#";
            case DATA -> "Data";
            case DEVOPS -> "DevOps";
            case BUSINESS -> "Business";
        };
    }
    public static Courses randomCourseType() { //selecting a random course
        return VALUES.get(projectRandomGenerator.inRange(0, COURSES_SIZE - 1)); //getting a random value/course from the list of courses (within our range)
    }
}

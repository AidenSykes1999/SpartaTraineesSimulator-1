package com.sparta.spartatraineesimulator.model;

import java.util.Random;

public class ProjectRandomGenerator {
    private final Random random;
    //constructor
    public ProjectRandomGenerator(long seed) {
        random = new Random(seed);}

    public int inRange(int minimum, int maximum) {          //specifying the range through this method, to use this later in picking a random course
        if (minimum > maximum) {                            //a negative value will result in IllegalArgumentException.
            throw new IllegalArgumentException(
                    "Provided a minimum value: , " + minimum
                    + ", and the maximum value: , " + maximum
                    + ", minimum value is greater than the maximum value");}
        //This method return a pseudorandom int value between 0 and specified value from random number generator sequence.
        return random.nextInt((int) ((long) (maximum) - (long) (minimum) + 1)) + minimum;}}

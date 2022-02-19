package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.ProjectRandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProjectRandomGeneratorTest {
    private static final long seed = 987654321;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 20;


    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected")
    public void generateRandomNumberCheck() {
        ProjectRandomGenerator projectRandomGenerator = new ProjectRandomGenerator(seed);
        List<Integer> listOfIntegers= new ArrayList<>();
        int randomValue;
        for (int count = 0; count < 10; count++) {
            randomValue = projectRandomGenerator.inRange(MINIMUM, MAXIMUM);
            listOfIntegers.add(randomValue);
        }
        for (int number : listOfIntegers) {
            Assertions.assertTrue(number >= MINIMUM && number <= MAXIMUM);
        }
    }
    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected, when the minimum is equal to the maximum value")
    public void generateRandomNumberWhenMinimumIsEqualToMaximum() {
        ProjectRandomGenerator projectRandomGenerator = new ProjectRandomGenerator(seed);
        projectRandomGenerator.inRange(MAXIMUM, MAXIMUM);
    }
    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected, when the minimum value is greater than the maximum value")
    public void generateRandomNumberWhenMinimumIsGreaterThanMaximum() {
        ProjectRandomGenerator projectRandomGenerator = new ProjectRandomGenerator(seed);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            projectRandomGenerator.inRange(MAXIMUM, MINIMUM);});
    }
}

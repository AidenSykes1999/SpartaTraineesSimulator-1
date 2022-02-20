package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.course.CourseRandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseRandomGeneratorTest {
    private static final long seed = 987654321;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 20;

    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected")
    public void generateRandomNumberCheck() {
        CourseRandomGenerator courseRandomGenerator = new CourseRandomGenerator(seed);
        List<Integer> listOfIntegers= new ArrayList<>();
        int randomValue;
        for (int count = 0; count < 10; count++) {
            randomValue = courseRandomGenerator.inRange(MINIMUM, MAXIMUM);
            listOfIntegers.add(randomValue);
        }
        for (int number : listOfIntegers) {
            Assertions.assertTrue(number >= MINIMUM && number <= MAXIMUM);
        }
    }

    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected, when the minimum is equal to the maximum value")
    public void generateRandomNumberWhenMinimumIsEqualToMaximum() {
        CourseRandomGenerator courseRandomGenerator = new CourseRandomGenerator(seed);
        courseRandomGenerator.inRange(MAXIMUM, MAXIMUM);
    }

    @Test
    @DisplayName("Test to check if the ProjectRandomGenerator works as expected, when the minimum value is greater than the maximum value")
    public void generateRandomNumberWhenMinimumIsGreaterThanMaximum() {
        CourseRandomGenerator courseRandomGenerator = new CourseRandomGenerator(seed);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            courseRandomGenerator.inRange(MAXIMUM, MINIMUM);});
    }
}

package com.sparta.spartatraineesimulator.modelTests;

import com.sparta.spartatraineesimulator.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseTest {

    @Test
    @DisplayName("Testing if the randomCourseType method works as expected")
    public void randomCourseType() {
        Assertions.assertNotNull(Course.randomCourseType());
    }

    @Test
    @DisplayName("Testing if a randomly selected course \"BUSINESS\" exist in the courses provided by the sparta academy")
    public void courseTypeTest() {
        Course course = Course.BUSINESS;
        assertNotNull(course.getCourse());
    }
}

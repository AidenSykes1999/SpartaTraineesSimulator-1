package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.Centre;
import com.sparta.spartatraineesimulator.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CentreTest {


    @Test
    @DisplayName("Given the project is run, ensure that Centre is runnable.")
    void getCentreTestMethod(){

        Centre centre = new Centre();

        Assertions.assertNotNull(centre);

    }

    @Test
    @DisplayName("Given the project is run, ensure that program can flag max capacity")
    void isMaxCapacity(){

        Centre centre = new Centre();

        centre.getCurrentCapacity();
        Boolean expected = centre.isCentreFull();

        Assertions.assertEquals(false,expected);

    }

    @Test
    @DisplayName("Given there is a Centre, ensure that program can find the number of empty spaces in the centre")
    void findEmptySpaceInCentre(){

        Centre centre = new Centre();
        int LIMIT = 100;
        int currentCapacity = 0;
        centre.getCurrentCapacity();

        int expected = centre.getEmptySpace();

        Assertions.assertEquals(100,expected);

    }

}

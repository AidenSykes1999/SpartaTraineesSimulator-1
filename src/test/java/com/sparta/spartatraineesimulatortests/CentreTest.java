package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.TechCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentreTest {


    @Test
    @DisplayName("Given the project is run, ensure that Centre is runnable.")
    void getCentreTestMethod(){

        TechCentre centre = new TechCentre();

        Assertions.assertNotNull(centre);

    }

    @Test
    @DisplayName("Given the project is run, ensure that program can flag max capacity")
    void isMaxCapacity(){

        TechCentre centre = new TechCentre();

        centre.getCurrentCapacity();
        Boolean expected = centre.isCentreFull();

        Assertions.assertEquals(false,expected);

    }

    @Test
    @DisplayName("Given there is a Centre, ensure that program can find the number of empty spaces in the centre")
    void findEmptySpaceInCentre(){

        TechCentre techCentre = new TechCentre();
        int LIMIT = 100;
        int currentCapacity = 0;
        techCentre.getCurrentCapacity();

        int expected = techCentre.getEmptySpace();

        Assertions.assertEquals(100,expected);

    }

}

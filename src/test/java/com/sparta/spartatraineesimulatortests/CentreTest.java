package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.centre.BootCamp;
import com.sparta.spartatraineesimulator.model.centre.TechCentre;
import com.sparta.spartatraineesimulator.model.centre.TrainingHub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentreTest {


    @Test
    @DisplayName("Given the project is run, ensure that Tech Centre is runnable.")
    void getTechCentreTestMethod(){

        TechCentre centre = new TechCentre(1);

        Assertions.assertNotNull(centre);

    }

    @Test
    @DisplayName("Given the project is run, ensure that BootCamp is runnable.")
    void getBootCampMethod(){

        BootCamp centre = new BootCamp(1);

        Assertions.assertNotNull(centre);

    }

    @Test
    @DisplayName("Given the project is run, ensure that Training Hub is runnable.")
    void getTrainingHubMethod(){

        TrainingHub centre = new TrainingHub(1);

        Assertions.assertNotNull(centre);

    }


    @Test
    @DisplayName("Given the project is run, ensure that program can flag max capacity")
    void isMaxCapacity(){

        TechCentre centre = new TechCentre(0);
        TrainingHub centre2 = new TrainingHub(1);
        BootCamp centre3 = new BootCamp(2);

        Boolean expected = centre.isCentreFull();
        Boolean expected2 = centre2.isCentreFull();
        Boolean expected3 = centre3.isCentreFull();

        Assertions.assertEquals(false,expected);
        Assertions.assertEquals(false,expected2);
        Assertions.assertEquals(false,expected3);
    }

    @Test
    @DisplayName("Given there is a Centre, ensure that program can find the number of empty spaces in the centre")
    void findEmptySpaceInCentre(){

        TechCentre techCentre = new TechCentre(1);

        int expected = techCentre.getEmptySpace();

        Assertions.assertEquals(techCentre.getLimit(),expected);

    }

    @Test
    @DisplayName("Given there is a Tech Centre. Check if the capacity is low enough to consider deleting the Centre.")
    void checkIfCentreNeedsToClose() {

        TechCentre techCentre = new TechCentre(2);
        techCentre.setCurrentCapacity(24);

        boolean expected = techCentre.shouldClose();

        Assertions.assertTrue(expected);


    }

    @Test
    @DisplayName("Given there is a Training Hub. Check if the capacity is low enough to consider deleting the Centre.")
    void checkIfTrainingHubNeedsToClose() {

        TrainingHub trainingHub = new TrainingHub(2);
        trainingHub.setCurrentCapacity(24);

        boolean expected = trainingHub.shouldClose();

        Assertions.assertTrue(expected);


    }


}

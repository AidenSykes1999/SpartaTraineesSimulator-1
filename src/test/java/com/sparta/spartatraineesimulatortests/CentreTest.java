package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.centre.BootCamp;
import com.sparta.spartatraineesimulator.model.centre.TechCentre;
import com.sparta.spartatraineesimulator.model.centre.TrainingHub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {24,23,15})
    @DisplayName("Given a Tech Centre is just created with below 25 trainees. Check that it's not closed right away.")
    void checkIfCentreNeedsHasCloseBuffer(int traineeNumber) {

        TechCentre techCentre = new TechCentre(2);
        techCentre.setCurrentCapacity(traineeNumber);

        boolean expected = techCentre.shouldClose();

        Assertions.assertFalse(expected);


    }

    @ParameterizedTest
    @ValueSource(ints = {24,23,15})
    @DisplayName("Given a Training Hub is just created with below 25 trainees. Check that it's not closed right away.")
    void checkIf_TrainingHub_HasCloseBuffer(int traineeNumber) {

        TrainingHub trainingHub = new TrainingHub(2);
        trainingHub.setCurrentCapacity(traineeNumber);

        boolean expected = trainingHub.shouldClose();

        Assertions.assertFalse(expected);


    }

    @ParameterizedTest
    @ValueSource(ints = {24,23,15})
    @DisplayName("Given a Tech Centre is just created with below 25 trainees. Check that it closes after using the close buffer.")
    void checkIf_Centre_CanCloseAfterBuffer(int traineeNumber) {

        TechCentre techCentre = new TechCentre(2);
        techCentre.setCurrentCapacity(traineeNumber);

        techCentre.shouldClose();
        boolean expected = techCentre.shouldClose();

        Assertions.assertTrue(expected);


    }

    @ParameterizedTest
    @ValueSource(ints = {24,23,15})
    @DisplayName("Given a Training Hub is just created with below 25 trainees. Check that it closes after using the close buffer.")
    void checkIf_TrainingHub_CanCloseAfterBuffer(int traineeNumber) {

        TrainingHub trainingHub = new TrainingHub(2);
        trainingHub.setCurrentCapacity(traineeNumber);

        trainingHub.shouldClose();
        boolean expected = trainingHub.shouldClose();

        Assertions.assertTrue(expected);


    }

    @ParameterizedTest
    @ValueSource(ints = {24,23,15})
    @DisplayName("Given a Bootcamp is just created with below 25 trainees. Check that it closes after 3 times.")
    void checkIf_Bootcamp_CanClose(int traineeNumber) {

        BootCamp bootCamp = new BootCamp(2);
        bootCamp.setCurrentCapacity(traineeNumber);

        bootCamp.shouldClose();
        bootCamp.shouldClose();
        boolean expected = bootCamp.shouldClose();

        Assertions.assertTrue(expected);

    }

    @ParameterizedTest
    @ValueSource(ints = {25,26,30})
    @DisplayName("Given a Bootcamp is just created with 25 or over trainees. Check that it doesn't close after 3 times.")
    void checkIf_Bootcamp_DoesntClose(int traineeNumber) {

        BootCamp bootCamp = new BootCamp(2);
        bootCamp.setCurrentCapacity(traineeNumber);

        bootCamp.shouldClose();
        bootCamp.shouldClose();
        boolean expected = bootCamp.shouldClose();

        Assertions.assertFalse(expected);

    }

}

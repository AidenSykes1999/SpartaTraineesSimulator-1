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
    @DisplayName("Given the project is run, ensure that Centre's getter and setter are functional")
    void testGetterAndSetter(){

        Centre centre = new Centre();
        ArrayList<Trainee> trainees;
        centre.getTrainees();
        ArrayList<Trainee> trainees1 = null ;
        centre.setTrainees(trainees1);

        Assertions.assertNotNull(centre);

    }



}

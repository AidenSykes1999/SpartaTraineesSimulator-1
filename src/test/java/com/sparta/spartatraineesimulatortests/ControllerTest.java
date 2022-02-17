package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ControllerTest {
    @Test
    @DisplayName("Given bounds (50, 101), the list size should be within these bounds")
    public void givenBoundsFiftyAndOneHundredAndOne_ReturnsListOfSizeWithinTheseBounds(){
        Controller controller = new Controller();
        ArrayList<Trainee> trainees;
        trainees = controller.generateTrainees();
        boolean actual = (trainees.size() >= 50 && trainees.size() <= 100);
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("When using runSimulationTick with current month 0, getNumberOfOpenCentres should be more than zero")
    public void givenTwelveMonths_CentresTotalShouldBeMoreThanZero(){
        Controller controller = new Controller();
        controller.runSimulationTick(0);
        int centresTotal = controller.getNumberOfOpenCentres();
        Assertions.assertEquals(true, centresTotal > 0);
    }

    @Test
    @DisplayName("Given using runSimulationTick with current month 0, totalEnlisted should be more than zero")
    public void givenTwelveMonths_TotalEnlistedShouldBeMoreThanZero(){
        Controller controller = new Controller();
        controller.runSimulationTick(0);
        int totalEnlisted = controller.getTotalEnlisted();
        Assertions.assertEquals(true, totalEnlisted > 0);
    }

}

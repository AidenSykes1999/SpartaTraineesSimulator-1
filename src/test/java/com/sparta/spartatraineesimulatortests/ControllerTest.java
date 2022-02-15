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

    // @Test
    // @DisplayName("Given twelve months, centresTotal should be more than zero")
    // public void givenTwelveMonths_CentresTotalShouldBeMoreThanZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(12);
    //     int centresTotal = controller.getCentres().size();
    //     Assertions.assertEquals(true, centresTotal > 0);
    // }
    //
    // @Test
    // @DisplayName("Given twelve months, totalEnlisted should be more than zero")
    // public void givenTwelveMonths_TotalEnlistedShouldBeMoreThanZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(12);
    //     int totalEnlisted = controller.getTotalEnlisted();
    //     Assertions.assertEquals(true, totalEnlisted > 0);
    // }
    //
    // @Test
    // @DisplayName("Given twelve months, waitingListTotal should be more than zero")
    // public void givenTwelveMonths_WaitingListTotalShouldBeMoreThanZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(12);
    //     int waitingListTotal = controller.getWaitingList().size();
    //     Assertions.assertEquals(true, waitingListTotal > 0);
    // }
    //
    // @Test
    // @DisplayName("Given zero months, centresTotal should be zero")
    // public void givenZeroMonths_CentresTotalShouldBeZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(0);
    //     int centresTotal = controller.getCentres().size();
    //     Assertions.assertEquals(true, centresTotal == 0);
    // }
    //
    // @Test
    // @DisplayName("Given zero months, totalEnlisted should be zero")
    // public void givenZeroMonths_TotalEnlistedShouldBeZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(0);
    //     int totalEnlisted = controller.getTotalEnlisted();
    //     Assertions.assertEquals(true, totalEnlisted == 0);
    // }
    //
    // @Test
    // @DisplayName("Given zero months, waitingListTotal should be more than zero")
    // public void givenZeroMonths_WaitingListTotalShouldBeMoreThanZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(0);
    //     int waitingListTotal = controller.getWaitingList().size();
    //     Assertions.assertEquals(true, waitingListTotal == 0);
    // }
    //
    // @Test
    // @DisplayName("Given minus one months, centresTotal should be zero")
    // public void givenMinusOneMonths_CentresTotalShouldBeZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(-1);
    //     int centresTotal = controller.getCentres().size();
    //     Assertions.assertEquals(true, centresTotal == 0);
    // }
    //
    // @Test
    // @DisplayName("Given minus one months, totalEnlisted should be zero")
    // public void givenMinusOneMonths_TotalEnlistedShouldBeZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(-1);
    //     int totalEnlisted = controller.getTotalEnlisted();
    //     Assertions.assertEquals(true, totalEnlisted == 0);
    // }
    //
    // @Test
    // @DisplayName("Given minus one months, waitingListTotal should be more than zero")
    // public void givenMinusOneMonths_WaitingListTotalShouldBeMoreThanZero(){
    //     Controller controller = new Controller();
    //     controller.runSimulation(-1);
    //     int waitingListTotal = controller.getWaitingList().size();
    //     Assertions.assertEquals(true, waitingListTotal == 0);
    // }
}

package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;
import com.sparta.spartatraineesimulator.model.centre.TrainingHub;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;
import com.sparta.spartatraineesimulator.model.trainee.TraineeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TraineeFactoryTest {
    @Test
    @DisplayName("Given the method is run, ensure that generateTrainees returns an array that is not null.")
    void givenGenerateTraineesMethod_ReturnedArrayListIsNotNull(){
        Assertions.assertNotNull(TraineeFactory.generateTrainees());
    }

    @Test
    @DisplayName("Given the method enlistTrainees is run, allTrainees array list should have the added number of trainees")
    public void givenEnlistTraineesMethod_AddsCorrectNumberOfTraineesToAllTraineesArrayList() {
        TraineeFactory traineeFactory = new TraineeFactory();
        traineeFactory.clearAllTrainees();
        ArrayList<Trainee> testList = new ArrayList<>();
        testList.add(new Trainee(1, 2));
        TraineeFactory.enlistTrainees(testList);
        Assertions.assertEquals(1, traineeFactory.getAllTrainees().size());
    }

    @Test
    @DisplayName("Given the method enlistTrainees is run, waitingList array list should have the added number of trainees")
    public void givenEnlistTraineesMethod_AddsCorrectNumberOfTraineesToWaitingListArrayList() {
        TraineeFactory traineeFactory = new TraineeFactory();
        traineeFactory.clearWaitingList();
        ArrayList<Trainee> testList = new ArrayList<>();
        testList.add(new Trainee(1, 2));
        TraineeFactory.enlistTrainees(testList);
        Assertions.assertEquals(1, traineeFactory.getWaitingList().size());
    }

    @Test
    @DisplayName("Given the method enlistTrainees is run, totalEnlisted should be equal to the number of added trainees")
    public void givenEnlistTraineesMethod_totalEnlistedIsEqualToTheNumberOfAddedTrainees() {
        TraineeFactory traineeFactory = new TraineeFactory();
        ArrayList<Trainee> testList = new ArrayList<>();
        testList.add(new Trainee(1, 2));
        TraineeFactory.enlistTrainees(testList);
        Assertions.assertEquals(1, traineeFactory.getTotalEnlisted());
    }

    @Test
    @DisplayName("Given the method benchTrainees is run, when there are 2 eligible trainees in 1 centre, the size of benchList should be 2")
    public void givenBenchTraineesMethod_When2EligibleTraineesInCentre_SizeOfBenchListShouldBe2() {
        TraineeFactory traineeFactory = new TraineeFactory();
        ArrayList<TrainingCentre> testList = new ArrayList<>();
        testList.add(new TrainingHub(1));
        ArrayList<Trainee> trainees = new ArrayList<>();
        trainees.add(new Trainee(1, 2));
        trainees.add(new Trainee(2, 0));
        trainees.add(new Trainee(3, 2));
        testList.get(0).setTrainees(trainees);
        TraineeFactory.benchTrainees(testList);
        Assertions.assertEquals(2, traineeFactory.getBenchList().size());
    }

    @Test
    @DisplayName("Given the method addAllWaitingList is run, waitingList should not be empty")
    public void givenAddAllWaitingListMethod_WaitingListShouldNotBeEmpty() {
        TraineeFactory traineeFactory = new TraineeFactory();
        ArrayList<Trainee> testList = new ArrayList<>();
        testList.add(new Trainee(1, 2));
        TraineeFactory.addAllWaitingList(testList);
        Assertions.assertNotNull(traineeFactory.getWaitingList());
    }
}

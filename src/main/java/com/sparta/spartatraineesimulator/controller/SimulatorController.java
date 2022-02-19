package com.sparta.spartatraineesimulator.controller;

import com.sparta.spartatraineesimulator.model.centre.*;
import com.sparta.spartatraineesimulator.model.client.ClientFactory;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;
import com.sparta.spartatraineesimulator.model.trainee.TraineeFactory;

import java.util.ArrayList;
import java.util.Collections;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class SimulatorController {

    private static TraineeFactory traineeFactory = new TraineeFactory();
    private static CentreFactory centreFactory = new CentreFactory();
    private static ClientFactory clientFactory = new ClientFactory();

    public SimulatorController(TraineeFactory traineeFactory, CentreFactory centreFactory, ClientFactory clientFactory) {

        this.traineeFactory = traineeFactory;
        this.centreFactory = centreFactory;
        this.clientFactory = clientFactory;

    }

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = TraineeFactory.generateTrainees();
        TraineeFactory.enlistTrainees(newTrainees);

        CentreFactory.createCenter(month);
        CentreFactory.addTraineesTechCentre(traineeFactory.getWaitingList());
        CentreFactory.addTraineesCentre(traineeFactory.getWaitingList());

        if (traineeFactory.getBenchList().size() > 3000){
            logger.warn("The waiting list has hit a size of " + traineeFactory.getBenchList().size()
                    + " this could be detrimental to the growth of the company");
        }



        // we will close the center if the current capacity of center is less than 25
        ArrayList<Trainee> reassignedTrainees = CentreFactory.closeCentres();
        reassignTrainees(reassignedTrainees);

        traineeFactory.benchTrainees(centreFactory.getOpenCentres());

        if (month >= 12 && month % 3 == 0){
            clientFactory.createClient();
        }

        clientFactory.addTraineesToClients(traineeFactory.getBenchList());
        clientFactory.updateClients();

        logger.debug("WaitingList size: " + traineeFactory.getWaitingList().size());
        logger.debug("BenchList size: " + traineeFactory.getBenchList().size());

    }

    private void reassignTrainees(ArrayList<Trainee> trainees) {
        // try to reassign trainees
        if (trainees.size() > 0) {

            logger.debug("Attempting to reassign trainees...");

            centreFactory.addTraineesTechCentre(trainees);
            centreFactory.addTraineesCentre(trainees);

            // if some trainees still need reassigning add them to front of waitingList
            Collections.reverse(traineeFactory.getWaitingList());
            TraineeFactory.addAllWaitingList(trainees);
            Collections.reverse(traineeFactory.getWaitingList());

        }

    }

    public boolean checkMonthCount(String count) {

        int monthCount;

        try {
            monthCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            logger.warn("Invalid month input, isn't a number");
            return false;
        }

        if (monthCount > 0) {
            logger.info("Valid month input");
            return true;
        }
        else {
            logger.warn("Invalid month input is not over 0");
            return false;
        }

    }

    public int parseMonthCount(String stringMonths) {
        return Integer.parseInt(stringMonths);
    }

    public boolean checkIncremental(String stringIncremental) {

        int increment;

        try {
            increment = Integer.parseInt(stringIncremental);
        } catch (NumberFormatException e) {
            logger.warn("Invalid increment input, isn't a number");
            return false;
        }

        if (increment == 0 || increment == 1) {
            logger.info("Valid increment input");
            return true;
        }
        else {
            logger.warn("Invalid increment input is not 0 or 1");
            return false;
        }
    }

    public boolean parseIncrement(String stringIncremental) {
        int incrementNum = Integer.parseInt(stringIncremental);
        return (incrementNum == 1);
    }
}


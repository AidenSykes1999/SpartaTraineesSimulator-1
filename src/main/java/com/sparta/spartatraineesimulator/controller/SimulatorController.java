package com.sparta.spartatraineesimulator.controller;

import com.sparta.spartatraineesimulator.model.*;
import com.sparta.spartatraineesimulator.model.centre.*;
import com.sparta.spartatraineesimulator.model.client.ClientFactory;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import java.util.ArrayList;
import java.util.Collections;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class SimulatorController {

    private final TraineeFactory traineeFactory = new TraineeFactory();
    private final CentreFactory centreFactory = new CentreFactory();
    private final ClientFactory clientFactory = new ClientFactory();
    private final DisplayManager displayManager = new DisplayManager();
    public static boolean doIncrement = DisplayManager.doPrintEachMonth();

    public void runSimulationTick (int month, int months) {

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

        TraineeFactory.benchTrainees(centreFactory.getCentres());

        if (month >= 12 && month % 3 == 0){
            clientFactory.createClient();
        }

        clientFactory.addTraineesToClients(traineeFactory.getBenchList());
        clientFactory.updateClients();
        if (doIncrement) {
            displayManager.displayTheDetails(centreFactory.getCentres(), centreFactory.getClosedCentres(), traineeFactory.getAllTrainees(), traineeFactory.getBenchList());
        }
        if (!doIncrement && month+1 == months) {
            displayManager.displayTheDetails(centreFactory.getCentres(), centreFactory.getClosedCentres(), traineeFactory.getAllTrainees(), traineeFactory.getBenchList());
        }

    }

    private void reassignTrainees(ArrayList<Trainee> trainees) {
        // try to reassign trainees
        if (trainees.size() > 0) {
            CentreFactory.addTraineesTechCentre(trainees);
            CentreFactory.addTraineesCentre(trainees);

            // if some trainees still need reassigning add them to front of waitingList
            Collections.reverse(traineeFactory.getWaitingList());
            TraineeFactory.addAllWaitingList(trainees);
            Collections.reverse(traineeFactory.getWaitingList());
        }
    }


}


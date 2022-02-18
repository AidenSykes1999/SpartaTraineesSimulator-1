package com.sparta.spartatraineesimulator.controller;

import com.sparta.spartatraineesimulator.model.*;
import com.sparta.spartatraineesimulator.model.centre.*;
import com.sparta.spartatraineesimulator.model.client.ClientFactory;

import java.util.ArrayList;
import java.util.Collections;

public class SimulatorController {

    private TraineeFactory traineeFactory = new TraineeFactory();
    private CentreFactory centreFactory = new CentreFactory();
    private ClientFactory clientFactory = new ClientFactory();

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = traineeFactory.generateTrainees();
        traineeFactory.enlistTrainees(newTrainees);

        centreFactory.createCenter(month);
        centreFactory.addTraineesTechCentre(traineeFactory.getWaitingList());
        centreFactory.addTraineesCentre(traineeFactory.getWaitingList());


        // we will close the center if the current capacity of center is less than 25
        ArrayList<Trainee> reassignedTrainees = centreFactory.closeCentres();
        reassignTrainees(reassignedTrainees);

        traineeFactory.benchTrainees(centreFactory.getCentres());

        if (month >= 12 && month % 3 == 0){
            clientFactory.createClient();
        }

        clientFactory.addTraineesToClients(traineeFactory.getBenchList());
        clientFactory.updateClients();
        clientFactory.displayClients();
    }

    private void reassignTrainees(ArrayList<Trainee> trainees) {
        // try to reassign trainees
        if (trainees.size() > 0) {
            centreFactory.addTraineesTechCentre(trainees);
            centreFactory.addTraineesCentre(trainees);

            // if some trainees still need reassigning add them to front of waitingList
            Collections.reverse(traineeFactory.getWaitingList());
            traineeFactory.addAllWaitingList(trainees);
            Collections.reverse(traineeFactory.getWaitingList());
        }
    }


}


package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.SimulatorController;
import com.sparta.spartatraineesimulator.model.centre.CentreFactory;
import com.sparta.spartatraineesimulator.model.client.ClientFactory;
import com.sparta.spartatraineesimulator.model.trainee.TraineeFactory;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimulatorMain {

    public static final Logger logger = LogManager.getLogger("Sparta-Simulator-Logger");

    private static DisplayManager dm = new DisplayManager();
    private static SimulatorController simulatorController;

    public static void main(String[] args) {

        TraineeFactory traineeFactory = new TraineeFactory();
        CentreFactory centreFactory = new CentreFactory();
        ClientFactory clientFactory = new ClientFactory();

        simulatorController = new SimulatorController(traineeFactory, centreFactory, clientFactory);

        int months = getMonthCountMain(dm, simulatorController);
        boolean isIncremental = getIncrementalMain();

        for(int i = 0; i < months; i++) {
            simulatorController.runSimulationTick(i);

            if (isIncremental) {
                dm.displayMonth(i);
                displayDetails(traineeFactory, centreFactory, clientFactory);
            }

        }

        dm.displayFinishedMsg(months);
        displayDetails(traineeFactory, centreFactory, clientFactory);

    }

    private static void displayDetails(TraineeFactory traineeFactory, CentreFactory centreFactory, ClientFactory clientFactory) {

        dm.displayOpenCentres(centreFactory.getOpenCentres());
        dm.displayClosedCentres(centreFactory.getClosedCentres());
        dm.displayFullCentres(centreFactory.getOpenCentres());

        dm.displayTrainingTrainees(centreFactory.getOpenCentres());
        dm.displayWaitingTrainees(traineeFactory.getWaitingList());
        dm.displayBenchedTrainees(traineeFactory.getBenchList());

        dm.displayClientTypes(clientFactory.getClients());
        dm.displayTraineesWithClient(clientFactory.getClients());

    }

    private static int getMonthCountMain(DisplayManager dm, SimulatorController simulatorController) {

        String stringMonths = dm.getMonths();
        boolean monthCheck = simulatorController.checkMonthCount(stringMonths);

        while (!monthCheck) {
            logger.warn("Invalid month input retrying");
            dm.displayInvalidMonthMsg();
            stringMonths = dm.getMonths();
            monthCheck = simulatorController.checkMonthCount(stringMonths);
        }

        return simulatorController.parseMonthCount(stringMonths);

    }

    private static boolean getIncrementalMain() {

        String stringIncremental = dm.getIsIncremental();
        boolean incrementalCheck = simulatorController.checkIncremental(stringIncremental);

        while (!incrementalCheck) {
            logger.warn("Invalid increment input retrying");
            dm.displayInvalidIncrementalMsg();
            stringIncremental = dm.getIsIncremental();
            incrementalCheck = simulatorController.checkIncremental(stringIncremental);
        }

        return simulatorController.parseIncrement(stringIncremental);

    }



}

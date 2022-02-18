package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.SimulatorController;
import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SimulatorMain {

    public static final Logger logger = LogManager.getLogger("Sparta-Simulator-Logger");

    public static void main(String[] args) {

        DisplayManager dm = new DisplayManager();
        SimulatorController simulatorController = new SimulatorController();

        int months = dm.numberOfMonths();
        dm.doPrintEachMonth();

        for(int i = 0; i < months; i++) {

            simulatorController.runSimulationTick(i);

//             if (doIncremental) {
//                 dm.displayTheDetails(simulatorController.getCentres(), simulatorController.getClosedCentres(), simulatorController.getAllTrainees());
//             }

            dm.displayMonthPassed();


        }

        // dm.displayTheDetails(centres, closedCentres, trainees);

//        FileWriterClass writer = new FileWriterClass();
//        writer.outputToFile(centres);
    }

}

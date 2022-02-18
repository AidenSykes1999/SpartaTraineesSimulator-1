package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.SimulatorController;
import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.TraineeFactory;
import com.sparta.spartatraineesimulator.model.centre.CentreFactory;
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


        for(int i = 0; i < months; i++) {

            simulatorController.runSimulationTick(i, months);

            dm.displayMonthPassed();


        }

        // dm.displayTheDetails(centres, closedCentres, trainees);

//        FileWriterClass writer = new FileWriterClass();
//        writer.outputToFile(centres);
    }

}

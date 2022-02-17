package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.TrainingCentre;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    public static final Logger logger = LogManager.getLogger("Sparta-Simulator-Logger");

    public static void main(String[] args) {

        DisplayManager dm = new DisplayManager();
        Controller controller = new Controller();

        int months = dm.numberOfMonths();
        boolean doIncremental = dm.doPrintEachMonth();

        for(int i = 0; i < months; i++) {

            controller.runSimulationTick(i);

            if (doIncremental) {
                dm.displayTheDetails(controller.getCentres(), controller.getClosedCentres(), controller.getAllTrainees());
            }

            System.out.println();
            System.out.println("centre capacity: ");
            // for debugging
            for (TrainingCentre centre : controller.getCentres()) {
                System.out.print(centre.getCurrentCapacity() + ", ");
            }

            System.out.println("Waiting list size: " + controller.getNumberOfTraineesWaiting());
            System.out.println("Total enrolled: " + controller.getTotalEnlisted());

            dm.displayMonthPassed();


        }

        ArrayList<Trainee> trainees = controller.getAllTrainees();
        ArrayList<TrainingCentre> centres = controller.getCentres();
        ArrayList<TrainingCentre> closedCentres = controller.getClosedCentres();

        dm.displayTheDetails(centres, closedCentres, trainees);

//        FileWriterClass writer = new FileWriterClass();
//        writer.outputToFile(centres);
    }

}

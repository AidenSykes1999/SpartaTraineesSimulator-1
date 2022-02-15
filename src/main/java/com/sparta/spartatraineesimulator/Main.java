package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.TrainingCentre;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import java.util.ArrayList;

public class Main {

    private static int currentMonth = 0;

    public static void main(String[] args) {

        DisplayManager dm = new DisplayManager();
        Controller controller = new Controller();

        int months = dm.numberOfMonths();

        for(int i = 0; i < months; i++) {

            controller.runSimulationTick(i);
            dm.displayMonthPassed();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentMonth++;

        }

        ArrayList<TrainingCentre> centres = controller.centres;

        dm.displayTheDetails(centres);
//        int numberOfFullCentres = controller.getNumberOfFullCentres();
//        int numberCurrentlyTraining = controller.getNumberCurrentlyTraining();
//        int numberOfTraineesWaiting = controller.getNumberOfTraineesWaiting();

        //dm.displayTheDetails(openCentres, numberOfFullCentres, numberCurrentlyTraining, numberOfTraineesWaiting);

    }

}

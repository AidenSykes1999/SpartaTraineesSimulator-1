package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.TrainingCentre;
import com.sparta.spartatraineesimulator.view.DisplayManager;
import com.sparta.spartatraineesimulator.view.FileWriterClass;

import java.util.ArrayList;

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

        int numberOfOpenCentres = controller.getNumberOfOpenCentres();
        int numberOfFullCentres = controller.getNumberOfFullCentres();
        int numberCurrentlyTraining = controller.getNumberCurrentlyTraining();
        int numberOfTraineesWaiting = controller.getNumberOfTraineesWaiting();
        ArrayList<TrainingCentre> centres = controller.getCentres();

        //dm.displayTheDetails(openCentres, numberOfFullCentres, numberCurrentlyTraining, numberOfTraineesWaiting);

        FileWriterClass writer = new FileWriterClass();
        writer.outputToFile(centres);
    }

}

package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.Trainee;
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
        boolean doIncremental = dm.doPrintEachMonth();

        for(int i = 0; i < months; i++) {

            controller.runSimulationTick(i, doIncremental);
            dm.displayMonthPassed();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentMonth++;

        }

//        int numberOfOpenCentres = controller.getNumberOfOpenCentres();
//        int numberOfFullCentres = controller.getNumberOfFullCentres();
//        int numberCurrentlyTraining = controller.getNumberCurrentlyTraining();
//        int numberOfTraineesWaiting = controller.getNumberOfTraineesWaiting();

        ArrayList<Trainee> trainees = controller.allTrainees;
        ArrayList<TrainingCentre> centres = controller.getCentres();

        dm.displayTheDetails(centres, trainees);

//        FileWriterClass writer = new FileWriterClass();
//        writer.outputToFile(centres);
    }

}

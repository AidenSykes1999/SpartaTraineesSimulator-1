package com.sparta.spartatraineesimulator.controller;

// tick stuff

import com.sparta.spartatraineesimulator.model.*;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private ArrayList<TrainingCentre> centres = new ArrayList<>();
    private ArrayList<Trainee> waitingList = new ArrayList<>();

    private int totalEnlisted = 0;
    private int traineeId = 0;

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = generateTrainees();
        waitingList.addAll(newTrainees);
        totalEnlisted += newTrainees.size();

        DisplayManager dm = new DisplayManager();
        System.out.println("1 month passed");
        createCenter(month);
        addTraineesToCentres();

        for (TrainingCentre centre : centres) {
            System.out.print(centre.getCurrentCapacity() + ", ");
        }

        System.out.println("Waiting list size: " + waitingList.size());

    }

    public ArrayList<Trainee> generateTrainees () {
        Random r = new Random();
        int numberOfTrainees = r.nextInt(50, 101);
        ArrayList<Trainee> newTrainees = new ArrayList<Trainee>();

        for (int i = 0; i < numberOfTrainees; i++) {
            newTrainees.add(new Trainee(traineeId, 0));
            traineeId++;
        }

        return newTrainees;
    }

    private void createCenter (int month) {
        if (month % 2 == 0) {

            int min = 1;
            int max = 3;

            // let 1 = Tech, 2 = Boot and 3 = Training
            int randomChoice = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (randomChoice) {
                case 1:
                    centres.add(new TechCentre());
                    break;
                case 2:
                    centres.add(new BootCamp());
                    break;
                case 3:
                    centres.add(new TrainingHub());
                    break;
            }
        }
    }

    private void addTraineesToCentres () {
        for (TrainingCentre centre : centres) {
            if (!centre.isCentreFull()) {
                int freeSpace = centre.getEmptySpace();

                if (freeSpace >= waitingList.size()) {
                    centre.addAllTrainees(waitingList);
                    waitingList.clear();
                } else if (freeSpace < waitingList.size()) {
                    List<Trainee> subListTrainee = waitingList.subList(0, freeSpace);
                    centre.addAllTrainees(subListTrainee);
                    waitingList.removeAll(subListTrainee);
                }
            }
        }
    }


    public int getNumberOfOpenCentres() {
        return centres.size();
    }

    public int getNumberOfFullCentres() {
        int totalFullCenters = 0;
        for (TrainingCentre centre : centres) {
            if (centre.isCentreFull()) {
                totalFullCenters++;
            }
        }

        return totalFullCenters;
    }

    public int getNumberCurrentlyTraining() {
        int totalTraining = 0;
        for (TrainingCentre centre : centres) {
            totalTraining += centre.getCurrentCapacity();
        }

        return totalTraining;
    }

    public int getNumberOfTraineesWaiting() {
        return waitingList.size();
    }
}


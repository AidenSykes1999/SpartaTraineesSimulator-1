package com.sparta.spartatraineesimulator.controller;

// tick stuff

import com.sparta.spartatraineesimulator.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    public ArrayList<TrainingCentre> centres = new ArrayList<>();
    public ArrayList<Trainee> waitingList = new ArrayList<>();

    private int totalEnlisted = 0;
    private int traineeId = 0;

    private int bootCampCount = 0;
    private int trainingHubCount = 0;

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = generateTrainees();
        waitingList.addAll(newTrainees);
        totalEnlisted += newTrainees.size();

        createCenter(month);
        addTraineesToCentres();

        // for debugging
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

            // 1 = TrainingHub, 2 = BootCamp && limit 2, 3 = TechCentre
            int randomChoice = (int) Math.floor(Math.random() * (max - min + 1) + min);

            // TrainingHub limit = 3
            if (randomChoice == 1 && trainingHubCount < 3) {
                centres.add(new TrainingHub());
                trainingHubCount++;
            }
            // BootCamp limit = 2
            else if (randomChoice == 2 && bootCampCount < 2) {
                centres.add(new BootCamp());
                bootCampCount++;
            }
            else if (randomChoice == 3) {
                centres.add(new TechCentre());

            }

        }
    }

    // A centre takes a random number of trainees every month. (0 - 50 trainees up to their capacity)
    private void addTraineesToCentres () {
        for (TrainingCentre centre : centres) {
            if (!centre.isCentreFull()) {

                int freeSpace = centre.getEmptySpace();

                // limit to the amount of trainee able to be taken is 50
                if (50 < freeSpace) {
                    freeSpace = 50;
                }

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

    public int getTotalEnlisted() {
        return totalEnlisted;
    }

    public ArrayList<TrainingCentre> getCentres() {
        return centres;
    }
}


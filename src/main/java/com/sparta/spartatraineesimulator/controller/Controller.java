package com.sparta.spartatraineesimulator.controller;

// tick stuff

import com.sparta.spartatraineesimulator.model.Centre;
import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private int totalEnlisted = 0;
    private int traineeId = 0;

    private ArrayList<Centre> centres = new ArrayList<>();
    private ArrayList<Trainee> waitingList = new ArrayList<>();

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = generateTrainees();
        waitingList.addAll(newTrainees);
        totalEnlisted += newTrainees.size();

        System.out.println("1 month passed");
        createCenter(month);
        addTraineesToCentres();

        for (Centre centre : centres) {
            System.out.print(centre.getCurrentCapacity() + ", ");
        }
        System.out.println("Waiting list size: " + waitingList.size());



        System.out.println("Total enlisted: " + totalEnlisted);

        int totalFullCenters = 0;
        int totalTraining = 0;

        for (Centre centre : centres) {

            if (centre.isCentreFull()) {
                totalFullCenters++;
            }

            totalTraining += centre.getCurrentCapacity();
        }


        System.out.println(dm.displayTheDetails(centres.size(), totalFullCenters, totalTraining, waitingList.size()));
//      System.out.println("Total centres: " + totalCenters/100);
//      System.out.println("Total waitingList size: " + waitingList.size());

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

    private void createCenter (int month){
        if (month % 2 == 0) {
            centres.add(new Centre());
        }
    }

    private void addTraineesToCentres () {
        for (Centre centre : centres) {
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


    public int getTotalEnlisted () {
        return totalEnlisted;
    }

    public ArrayList<Centre> getCentres () {
        return centres;
    }

    public ArrayList<Trainee> getWaitingList () {
        return waitingList;
    }

}


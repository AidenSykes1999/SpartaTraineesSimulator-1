package com.sparta.spartatraineesimulator.controller;

import com.sparta.spartatraineesimulator.model.*;
import com.sparta.spartatraineesimulator.model.centre.BootCamp;
import com.sparta.spartatraineesimulator.model.centre.TechCentre;
import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;
import com.sparta.spartatraineesimulator.model.centre.TrainingHub;
import com.sparta.spartatraineesimulator.model.client.ClientFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatorController {

    private ArrayList<TrainingCentre> centres = new ArrayList<>();
    private ArrayList<TrainingCentre> closedCentres = new ArrayList<>();

    private ArrayList<Trainee> waitingList = new ArrayList<>();
    private ArrayList<Trainee> benchList = new ArrayList<>();
    private ArrayList<Trainee> allTrainees = new ArrayList<>();

    private int totalEnlisted = 0;
    private int traineeId = 0;

    private int bootCampCount = 0;
    private int trainingHubCount = 0;
    
    ClientFactory clientFactory = new ClientFactory();

    public void runSimulationTick (int month) {

        ArrayList<Trainee> newTrainees = generateTrainees();

        allTrainees.addAll(newTrainees);

        waitingList.addAll(newTrainees);
        totalEnlisted += newTrainees.size();

        createCenter(month);
        addTraineesTechCentre(waitingList);
        addTraineesCentre(waitingList);

        // we will close the center if the current capacity of center is less than 25
        ArrayList<Trainee> reassignedTrainees = closeCentres();
        // try to reassign trainees
        if (reassignedTrainees.size() > 0) {
            addTraineesTechCentre(reassignedTrainees);
            addTraineesCentre(reassignedTrainees);

            // if some trainees still need reassigning add them to front of waitingList
            Collections.reverse(waitingList);
            waitingList.addAll(reassignedTrainees);
            Collections.reverse(waitingList);
        }

        ArrayList<Trainee> needsRemoving = new ArrayList<>();

        for (TrainingCentre centre : centres) {

            for (Trainee trainee : centre.getTrainees()) {

                trainee.incrementTrainingTime();

                if (trainee.getTrainingTime() == 3) {
                    benchList.add(trainee);
                    needsRemoving.add(trainee);
                }

            }

            centre.removeCollectionTrainees(needsRemoving);
            needsRemoving.clear();

        }

        System.out.println("Bench List size: " + benchList.size());
        System.out.println(trainingAndWaitingIncrement(benchList));

        if (month >= 12 && month % 3 == 0){
            clientFactory.createClient();
        }

        clientFactory.addTraineesToClients(benchList);
        clientFactory.updateRecruitingClients();
        clientFactory.updateHappyClients();

        System.out.println("happy clients size: " + clientFactory.getHappyClients().size());
        System.out.println("unhappy clients size: " + clientFactory.getUnhappyClients().size());
        System.out.println("recruiting clients size: " + clientFactory.getRecruitingClients().size());

        clientFactory.displayClients();
    }

    public StringBuilder trainingAndWaitingIncrement(ArrayList<Trainee> trainees){

        StringBuilder sb = new StringBuilder();
        int trainingJava = 0, trainingCSharp = 0, trainingData = 0, trainingDevOps = 0, trainingBusiness = 0,
                waitingJava = 0, waitingCSharp = 0, waitingData = 0, waitingDevOps = 0, waitingBusiness = 0;

        for (Trainee t: trainees){
            if (t.isWaiting()){
                switch (t.getCourseType()) {
                    case JAVA -> waitingJava++;
                    case C_SHARP -> waitingCSharp++;
                    case DATA -> waitingData++;
                    case DEVOPS -> waitingDevOps++;
                    case BUSINESS -> waitingBusiness++;
                }
            }
            else{
                switch (t.getCourseType()){
                    case JAVA -> trainingJava++;
                    case C_SHARP -> trainingCSharp++;
                    case DATA -> trainingData++;
                    case DEVOPS -> trainingDevOps++;
                    case BUSINESS -> trainingBusiness++;
                }

            }
        }

        return sb.append("Total bench: Java - ").append(trainingJava).append(". C# - ").append(trainingCSharp)
                .append(". Data - ").append(trainingData).append(". DevOps - ").append(trainingDevOps)
                .append(". Business - ").append(trainingBusiness).append(". \n").append("Total waiting: Java - ")
                .append(waitingJava).append(". C# - ").append(waitingCSharp).append(". Data - ").append(waitingData)
                .append(". DevOps - ").append(waitingDevOps).append(". Business - ").append(waitingBusiness).append(". \n");
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
            } else if (randomChoice == 3) {
                centres.add(new TechCentre());

            }

        }
    }

    private void addTraineesTechCentre(ArrayList<Trainee> trainees) {
        for (TrainingCentre centre : centres) {

            if (centre.hasCourse() && !centre.isCentreFull()) {

                ArrayList<Trainee> traineeAddList = new ArrayList<>();

                for (Trainee trainee : trainees) {
                    if (trainee.getCourseType() == centre.getCourseType()) {
                        traineeAddList.add(trainee);
                    }
                }

                int freeSpace = centre.getEmptySpace();

                // limit to the amount of trainee able to be taken is 50
                if (50 < freeSpace) {
                    freeSpace = 50;
                }

                if (freeSpace >= traineeAddList.size()) {
                    centre.addAllTrainees(traineeAddList);
                    trainees.removeAll(traineeAddList);
                } else if (freeSpace < traineeAddList.size()) {
                    List<Trainee> addedTrainees = traineeAddList.subList(0, freeSpace);
                    centre.addAllTrainees(addedTrainees);
                    trainees.removeAll(addedTrainees);

                }

            }

        }

    }

    // A centre takes a random number of trainees every month. (0 - 50 trainees up to their capacity)
    private void addTraineesCentre(ArrayList<Trainee> trainees) {
        for (TrainingCentre centre : centres) {
            if (!centre.hasCourse() && !centre.isCentreFull()) {

                int freeSpace = centre.getEmptySpace();

                // limit to the amount of trainee able to be taken is 50
                if (50 < freeSpace) {
                    freeSpace = 50;
                }

                if (freeSpace >= trainees.size()) {
                    centre.addAllTrainees(trainees);
                    trainees.clear();
                } else if (freeSpace < trainees.size()) {
                    List<Trainee> addedTrainees = trainees.subList(0, freeSpace);
                    centre.addAllTrainees(addedTrainees);
                    trainees.removeAll(addedTrainees);

                }

            }
        }
    }

    private ArrayList<Trainee> closeCentres() {

        ArrayList<Trainee> traineesRemovedFromCentre = new ArrayList<>();
        ArrayList<TrainingCentre> centresToBeRemoved = new ArrayList<>();

        for (TrainingCentre centre : centres) {
            if (centre.shouldClose()) {
                ArrayList<Trainee> trainees = centre.getTrainees();
                traineesRemovedFromCentre.addAll(trainees);
                // System.out.println("Since the current capacity(" + centre.getCurrentCapacity() + ") of centre is less than 25, so closing the centre");
                if ("Bootcamp".equals(centre.getName())){
                    bootCampCount--;
                }
                if ("Training Hub".equals(centre.getName())){
                    trainingHubCount--;
                }

                centresToBeRemoved.add(centre);
                centre.removeTrainees();
            }
        }

        centres.removeAll(centresToBeRemoved);
        closedCentres.addAll(centresToBeRemoved);

        return traineesRemovedFromCentre;

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

    public ArrayList<Trainee> getAllTrainees() {
        return allTrainees;
    }

    public ArrayList<TrainingCentre> getClosedCentres() {
        return closedCentres;
    }

    public void removeFromBenchList(ArrayList<Trainee> traineeList){
        for (int i = 0; i < traineeList.size(); i++){
            benchList.remove(traineeList.get(i));
        }
    }

    public void clearBenchList(){
        benchList.clear();
    }
}


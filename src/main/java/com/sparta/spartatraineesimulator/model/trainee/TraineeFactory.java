package com.sparta.spartatraineesimulator.model.trainee;

import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;

import java.util.ArrayList;
import java.util.Random;

public class TraineeFactory {

    private static int traineeId = 0;
    private static int totalEnlisted = 0;

    private static Random r = new Random();

    private static ArrayList<Trainee> waitingList = new ArrayList<>();
    private static ArrayList<Trainee> benchList = new ArrayList<>();
    private static ArrayList<Trainee> allTrainees = new ArrayList<>();

    public static ArrayList<Trainee> generateTrainees () {

        int numberOfTrainees = r.nextInt(50, 101);
        ArrayList<Trainee> newTrainees = new ArrayList<Trainee>();

        for (int i = 0; i < numberOfTrainees; i++) {
            newTrainees.add(new Trainee(traineeId, 0));
            traineeId++;
        }

        return newTrainees;
    }

    public static void enlistTrainees(ArrayList<Trainee> newTrainees) {
        allTrainees.addAll(newTrainees);

        waitingList.addAll(newTrainees);
        totalEnlisted += newTrainees.size();
    }

    public static void benchTrainees(ArrayList<TrainingCentre> centres) {

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
    }

    public static void addAllWaitingList(ArrayList<Trainee> trainees) {
        waitingList.addAll(trainees);
    }

    public ArrayList<Trainee> getWaitingList() {
        return waitingList;
    }

    public ArrayList<Trainee> getBenchList() {
        return benchList;
    }

    public int getTotalEnlisted() {
        return totalEnlisted;
    }
}

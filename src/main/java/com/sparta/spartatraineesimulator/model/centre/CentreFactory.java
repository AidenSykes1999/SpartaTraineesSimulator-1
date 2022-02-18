package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.Trainee;

import java.util.ArrayList;
import java.util.List;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class CentreFactory {

    private static ArrayList<TrainingCentre> centres = new ArrayList<>();
    private static ArrayList<TrainingCentre> closedCentres = new ArrayList<>();

    private static int bootCampCount = 0;
    private static int trainingHubCount = 0;

    public static void createCenter (int month) {
        if (month % 2 == 0) {

            int min = 1;
            int max = 3;

            // 1 = TrainingHub, 2 = BootCamp && limit 2, 3 = TechCentre
            int randomChoice = (int) Math.floor(Math.random() * (max - min + 1) + min);

            // TrainingHub limit = 3
            if (randomChoice == 1 && trainingHubCount < 3) {
                centres.add(new TrainingHub());
                logger.info("Opened a New Training Hub");
                trainingHubCount++;
            }
            // BootCamp limit = 2
            else if (randomChoice == 2 && bootCampCount < 2) {
                centres.add(new BootCamp());
                logger.info("Opened a New Boot Camp");
                bootCampCount++;
            } else if (randomChoice == 3) {
                centres.add(new TechCentre());
                logger.info("Opened a New Tech Centre");
            }

        }
    }

    public static void addTraineesTechCentre(ArrayList<Trainee> trainees) {
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
    public static void addTraineesCentre(ArrayList<Trainee> trainees) {
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

    public static ArrayList<Trainee> closeCentres() {

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

                logger.error(centre.getName() + " removed following requirement checks failed");

                centresToBeRemoved.add(centre);
                centre.removeTrainees();
            }
        }

        centres.removeAll(centresToBeRemoved);
        closedCentres.addAll(centresToBeRemoved);

        return traineesRemovedFromCentre;

    }

    public ArrayList<TrainingCentre> getCentres() {
        return centres;
    }


    public ArrayList<TrainingCentre> getClosedCentres() {
        return closedCentres;
    }

    public int getNumberCurrentlyTraining() {
        int totalTraining = 0;
        for (TrainingCentre centre : centres) {
            totalTraining += centre.getCurrentCapacity();
        }

        return totalTraining;
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

}

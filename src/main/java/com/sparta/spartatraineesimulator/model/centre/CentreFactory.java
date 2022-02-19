package com.sparta.spartatraineesimulator.model.centre;

import com.sparta.spartatraineesimulator.model.trainee.Trainee;

import java.util.ArrayList;
import java.util.List;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class CentreFactory {

    private static ArrayList<TrainingCentre> openCentres = new ArrayList<>();
    private static ArrayList<TrainingCentre> closedCentres = new ArrayList<>();

    private static int bootCampCount = 0;
    private static int trainingHubCount = 0;

    private static int id = 0;

    public static void createCenter (int month) {
        if (month % 2 == 0) {

            int min = 1;
            int max = 3;

            // 1 = TrainingHub, 2 = BootCamp && limit 2, 3 = TechCentre
            int randomChoice = (int) Math.floor(Math.random() * (max - min + 1) + min);

            // TrainingHub limit = 3
            if (randomChoice == 1 && trainingHubCount < 3) {
                openCentres.add(new TrainingHub(id));
                logger.debug("Creating TrainingHub, ID: " +  id);
                trainingHubCount++;
            }
            // BootCamp limit = 2
            else if (randomChoice == 2 && bootCampCount < 2) {
                openCentres.add(new BootCamp(id));
                logger.debug("Creating Bootcamp, ID: " +  id);
                bootCampCount++;
            } else if (randomChoice == 3) {
                openCentres.add(new TechCentre(id));
                logger.debug("Creating TechCentre, ID: " +  id);

            }

            id++;

        }
    }

    public static void addTraineesTechCentre(ArrayList<Trainee> trainees) {
        for (TrainingCentre centre : openCentres) {

            if (centre.hasCourse() && !centre.isCentreFull()) {

                logger.debug("Added trainees to " + centre.getName() + ", ID: " + centre.getId());

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
        for (TrainingCentre centre : openCentres) {
            if (!centre.hasCourse() && !centre.isCentreFull()) {

                logger.debug("Adding trainees to " + centre.getName() + ", ID: " + centre.getId());

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

        for (TrainingCentre centre : openCentres) {
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

                logger.debug("Closing " + centre.getName() + " ID: " + centre.getId());
            }
        }

        openCentres.removeAll(centresToBeRemoved);
        closedCentres.addAll(centresToBeRemoved);

        return traineesRemovedFromCentre;

    }

    public ArrayList<TrainingCentre> getOpenCentres() {
        return openCentres;
    }


    public ArrayList<TrainingCentre> getClosedCentres() {
        return closedCentres;
    }

    public int getNumberCurrentlyTraining() {
        int totalTraining = 0;
        for (TrainingCentre centre : openCentres) {
            totalTraining += centre.getCurrentCapacity();
        }

        return totalTraining;
    }

    public int getNumberOfOpenCentres() {
        return openCentres.size();
    }

    public int getNumberOfFullCentres() {
        int totalFullCenters = 0;
        for (TrainingCentre centre : openCentres) {
            if (centre.isCentreFull()) {
                totalFullCenters++;
            }
        }

        return totalFullCenters;
    }

}

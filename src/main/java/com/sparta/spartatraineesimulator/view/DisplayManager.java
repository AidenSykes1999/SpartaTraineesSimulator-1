package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class DisplayManager {

    private boolean doIncrement = false;

    private int totalMonths = 0;
    private int monthCount = 0;
    private StringBuilder sb = new StringBuilder();
    // Allows the user to specify a non-negative or non-zero integer for the length of time to simulate
    public int numberOfMonths(){
        int numberOfMonths = 12;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many months would you like to simulate?");
        while (scanner.hasNext()){
            numberOfMonths = scanner.nextInt();
            if (numberOfMonths < 1){
                numberOfMonths = 12;
            }
            else
                return numberOfMonths;


        }
        this.totalMonths = numberOfMonths;
        return numberOfMonths;
    }

    // Gathers the information and sends it to be formatted and then output once all of it is collated
    // Deletes the contents once it has output that data for the next batch of output
    public void displayTheDetails(ArrayList<TrainingCentre> openCentres, ArrayList<TrainingCentre> closedCentres, ArrayList<Trainee> allTrainees){

        totalOpenCentres(openCentres);
        totalClosedCentres(closedCentres);
        totalFullCentres(openCentres);
        trainingAndWaitingIncrement(allTrainees);
        // Calls the methods and appends the details to the StringBuilder


        logger.info("Output the data");



        if (doIncrement){
            System.out.println(sb);
        }
        else{
            if (totalMonths == monthCount){
                System.out.println(sb);
            }
        }
        // Prints the culmination of the StringBuilder, incrementally each month or all at once


        sb.delete(0, sb.length());
    }

    // Offers the user the choice of output each month or all at the end of the simulation
    public void doPrintEachMonth(){
        boolean isTrue = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like incrementally display each month? (Default: No)");
        String str = scanner.next();
        if ("yes".equalsIgnoreCase(str)){
            isTrue = true;
        }
        this.doIncrement = isTrue;
    }

    // Calculates the current Open Centres based on the three that can exist
    // Appends that information to a prepared String
    private StringBuilder totalOpenCentres(ArrayList<TrainingCentre> openCentres) {
        int totalOpenBootcamps = 0;
        int totalOpenTrainingHubs = 0;
        int totalOpenTechCentres = 0;

        for (TrainingCentre tc: openCentres){
            switch (tc.getName()){
                case "Bootcamp" -> totalOpenBootcamps++;
                case "Training Hub" -> totalOpenTrainingHubs++;
                case "Tech Centre" -> totalOpenTechCentres++;
            }
        }

        return sb.append("Total open centres: Training Hub - ")
                .append(totalOpenTrainingHubs).append(", Bootcamp - ")
                .append(totalOpenBootcamps).append(". Tech Centre - ")
                .append(totalOpenTechCentres).append(".\n");
    }
    // Calculates the current Closed Centres based on the three that can exist
    // Appends that information to a prepared String
    private StringBuilder totalClosedCentres(ArrayList<TrainingCentre> closedCentres) {

        int totalClosedBootcamps = 0;
        int totalClosedTrainingHubs = 0;
        int totalClosedTechCentres = 0;

        for (TrainingCentre tc: closedCentres){
            switch (tc.getName()){
                case "Bootcamp" -> totalClosedBootcamps++;
                case "Training Hub" -> totalClosedTrainingHubs++;
                case "Tech Centre" -> totalClosedTechCentres++;
            }
        }

        return sb.append("Total closed centres: Training Hub - ")
                .append(totalClosedTrainingHubs).append(". Bootcamp - ")
                .append(totalClosedBootcamps).append(". Tech Centre - ")
                .append(totalClosedTechCentres).append(".\n");
    }

    /* Calculates the current Full Centres based on the three that can exist
     Appends that information to a prepared String
     */
    private StringBuilder totalFullCentres(ArrayList<TrainingCentre> openCentres) {
        int totalFullBootcamps = 0;
        int totalFullTrainingHubs = 0;
        int totalFullTechCentres = 0;

        for (TrainingCentre tc: openCentres){
            if (tc.isCentreFull())
                switch (tc.getName()){
                    case "Bootcamp" -> totalFullBootcamps++;
                    case "Training Hub" -> totalFullTrainingHubs++;
                    case "Tech Centre" -> totalFullTechCentres++;
                }
        }

        return sb.append("Total full centres: Training Hub - ")
                    .append(totalFullTrainingHubs).append(", Bootcamp - ")
                    .append(totalFullBootcamps).append(". Tech Centre - ")
                    .append(totalFullTechCentres).append(".\n");
    }


    /*
    * Initialises the Training and Waiting Learning Streams to allow the counting of them from zero.
    * Checks each trainee and if they're waiting. If they are, they increment the Waiting Streams
    * and if they're not waiting the Training Streams get incremented all based on the course type.
    * For example: Trainee 56 is Training and in the Java Stream, that would +1 trainingJava
    */
    public StringBuilder trainingAndWaitingIncrement(ArrayList<Trainee> trainees){
        int trainingJava = 0, trainingCSharp = 0, trainingData = 0, trainingDevOps = 0, trainingBusiness = 0,
                waitingJava = 0, waitingCSharp = 0, waitingData = 0, waitingDevOps = 0, waitingBusiness = 0, onTheBench = 0;

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
            else if (t.getTrainingTime() < 3) {
                    switch (t.getCourseType()) {
                        case JAVA -> trainingJava++;
                        case C_SHARP -> trainingCSharp++;
                        case DATA -> trainingData++;
                        case DEVOPS -> trainingDevOps++;
                        case BUSINESS -> trainingBusiness++;
                    }
            }
            else {
                onTheBench++;
            }
        }

        return sb.append("\nTotal training: Java - ").append(trainingJava).append(". C# - ").append(trainingCSharp)
                .append(". Data - ").append(trainingData).append(". DevOps - ").append(trainingDevOps)
                .append(". Business - ").append(trainingBusiness).append(". \n").append("Total waiting: Java - ")
                .append(waitingJava).append(". C# - ").append(waitingCSharp).append(". Data - ").append(waitingData)
                .append(". DevOps - ").append(waitingDevOps).append(". Business - ").append(waitingBusiness).append(". \n")
                .append("Current Spartans on the Bench - ").append(onTheBench).append(". \n");
    }

    // Uses the variable monthCount and increments it each pass through to display the correct current month
    public void displayMonthPassed() {
        monthCount++;
        System.out.println("Month " + monthCount + "\n");
        logger.info("1 Month has passed");
    }

//    public String messageFromACompany(ArrayList<Trainee> goneToWork, String company){
//
//        StringBuilder stringBuilder = new StringBuilder();
//        int total = goneToWork.size();
//
//        return stringBuilder.append(total).append(" ").append(goneToWork.get(0).getCourseType())
//                .append(" have been taken by ").append(company).toString();
//    }
}

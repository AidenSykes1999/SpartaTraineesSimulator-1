package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.TrainingCentre;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {
    private int monthCount = 0;
    StringBuilder sb = new StringBuilder();
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
        return numberOfMonths;
    }


    public void displayTheDetails(ArrayList<TrainingCentre> openCentres, ArrayList<Trainee> allTrainees){

        totalOpenCentres(openCentres);
        totalClosedCentres(openCentres);
        totalFullCentres(openCentres);
        trainingAndWaitingIncrement(allTrainees);
        // Calls the methods and appends the details to the StringBuilder


        System.out.println(sb); // Prints the culmination of the StringBuilder, incrementally each month or all at once

        sb.delete(0, sb.length());
    }

    public boolean doPrintEachMonth(){
        boolean isTrue = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like incrementally display each month? (Default: No)");
        String str = scanner.next();
        if ("yes".equalsIgnoreCase(str)){
            isTrue = true;
        }
        return isTrue;
    }

    private StringBuilder totalClosedCentres(ArrayList<TrainingCentre> openCentres) {

        return sb.append("Total closed centres: Training Hub - ").append(". Bootcamp - ").append(". Tech Centre - ").append(".\n\n");
    }

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
                .append(totalOpenTechCentres).append(".\n\n");
    }

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
                    .append(totalFullTechCentres).append(".\n\n");
    }



    public StringBuilder trainingAndWaitingIncrement(ArrayList<Trainee> trainees){
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

        return sb.append("Total training: Java - ").append(trainingJava).append(". C# - ").append(trainingCSharp)
                .append(". Data - ").append(trainingData).append(". DevOps - ").append(trainingDevOps)
                .append(". Business - ").append(trainingBusiness).append(". \n\n").append("Total waiting: Java - ")
                .append(waitingJava).append(". C# - ").append(waitingCSharp).append(". Data - ").append(waitingData)
                .append(". DevOps - ").append(waitingDevOps).append(". Business - ").append(waitingBusiness).append(". \n");
    }

    public void displayMonthPassed() {
        monthCount++;
        System.out.println("Month " + monthCount);
    }
}

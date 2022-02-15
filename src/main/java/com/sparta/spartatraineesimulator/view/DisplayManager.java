package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.model.Trainee;
import com.sparta.spartatraineesimulator.model.TrainingCentre;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {

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

        int trainingJava = 0, trainingCSharp = 0, trainingData = 0, trainingDevOps = 0, trainingBusiness = 0,
                waitingJava = 0, waitingCSharp = 0, waitingData = 0, waitingDevOps = 0, waitingBusiness = 0;

        for (Trainee t: allTrainees){
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

        String output = "Total open centres: Training Hub - " + totalOpenTrainingHubs + ", Bootcamp - " + totalOpenBootcamps + ". Tech Centre - " + totalOpenTechCentres + ".\n" +
                "Total closed centres: Training Hub - " + ". Bootcamp - " + ". Tech Centre - " + ".\n" +
                "Total full centres: Training Hub - " + totalFullTrainingHubs + ". Bootcamp - " + totalFullBootcamps + ". Tech Centre - " + totalFullTechCentres + ". \n" +
                "Total training: Java - " + trainingJava + ". C# - " + trainingCSharp + ". Data - " + trainingData + ". DevOps - " + trainingDevOps + ". Business - " + trainingBusiness + ". \n" +
                "Total waiting: Java - " + waitingJava + ". C# - " + waitingCSharp + ". Data - " + waitingData + ". DevOps - " + waitingDevOps + ". Business - " + waitingBusiness + ". \n";

        System.out.println(output);
    }

    public void displayMonthPassed() {
        System.out.println("1 month passed");
    }
}

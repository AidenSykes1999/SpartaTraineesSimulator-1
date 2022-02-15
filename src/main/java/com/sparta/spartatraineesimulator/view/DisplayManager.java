package com.sparta.spartatraineesimulator.view;

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


    public void displayTheDetails(ArrayList<TrainingCentre> openCentres){

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

        String output = "Total open centres: Training Hub - " + totalOpenTrainingHubs + ", Bootcamp - " + totalOpenBootcamps + ". Tech Centre - " + totalOpenTechCentres + ".\n" +
                "" +
                "Total full centres: Training Hub - " + totalFullTrainingHubs + ". Bootcamp - " + totalFullBootcamps + ". Tech Centre - " + totalFullTechCentres + ". \n" +
                "";

        System.out.println(output);
    }

    public void displayMonthPassed() {
        System.out.println("1 month passed");
    }
}

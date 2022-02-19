package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.model.client.Client;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;
import com.sparta.spartatraineesimulator.model.centre.TrainingCentre;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {

    private StringBuilder sb = new StringBuilder();
    // Allows the user to specify a non-negative or non-zero integer for the length of time to simulate

    public String getMonths(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many months would you like to simulate?");

        String numberOfMonths = scanner.next();

        return numberOfMonths;
    }

    public String getIsIncremental() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to get monthly updates? (1: Yes, 0: No)");

        String incremental = scanner.next();

        return incremental;

    }

    public void displayInvalidMonthMsg() {
        System.out.println("Invalid months please input a number over 0");
    }

    public void displayInvalidIncrementalMsg() {
        System.out.println("Invalid increment please input 0 or 1");
    }

    public void displayMonth(int i) {
        System.out.println("\nMonth " + (i+1) + ":");
    }

    // Calculates the current Open Centres based on the three that can exist
    // Appends that information to a prepared String
    public void displayOpenCentres(ArrayList<TrainingCentre> openCentres) {

        int totalOpenBootcamps = 0;
        int totalOpenTrainingHubs = 0;
        int totalOpenTechCentres = 0;

        int java = 0, cSharp = 0, data = 0, devOps = 0, business = 0;

        for (TrainingCentre tc: openCentres){
            String name = tc.getName();

            if (name == "Bootcamp") {
                totalOpenBootcamps++;
            }
            else if (name == "Training Hub") {
                totalOpenTrainingHubs++;
            }
            else if (name == "Tech Centre") {
                totalOpenTechCentres++;

                switch (tc.getCourseType()) {
                    case JAVA -> java++;
                    case C_SHARP -> cSharp++;
                    case DATA -> data++;
                    case DEVOPS -> devOps++;
                    case BUSINESS -> business++;
                }

            }
        }

        sb.append("Open centres: Training Hub - ")
                .append(totalOpenTrainingHubs).append(", Bootcamp - ")
                .append(totalOpenBootcamps).append(". Tech Centre - ")
                .append(totalOpenTechCentres).append(" ( Java - ")
                .append(java).append(". C# - ").append(cSharp)
                .append(". Data - ").append(data).append(". DevOps - ")
                .append(devOps).append(". Business - ").append(business)
                .append(" )");
        ;

        System.out.println(sb);
        sb.setLength(0);

    }

    // Calculates the current Closed Centres based on the three that can exist
    // Appends that information to a prepared String
    public void displayClosedCentres(ArrayList<TrainingCentre> closedCentres) {

        int totalClosedBootcamps = 0;
        int totalClosedTrainingHubs = 0;
        int totalClosedTechCentres = 0;

        int java = 0, cSharp = 0, data = 0, devOps = 0, business = 0;

        for (TrainingCentre tc: closedCentres){
            String name = tc.getName();

            if (name == "Bootcamp") {
                totalClosedBootcamps++;
            }
            else if (name == "Training Hub") {
                totalClosedTrainingHubs++;
            }
            else if (name == "Tech Centre") {
                totalClosedTechCentres++;

                switch (tc.getCourseType()) {
                    case JAVA -> java++;
                    case C_SHARP -> cSharp++;
                    case DATA -> data++;
                    case DEVOPS -> devOps++;
                    case BUSINESS -> business++;
                }

            }


        }

        sb.append("Closed centres: Training Hub - ")
                .append(totalClosedTrainingHubs).append(". Bootcamp - ")
                .append(totalClosedBootcamps).append(". Tech Centre - ")
                .append(totalClosedTechCentres).append(" ( Java - ")
                .append(java).append(". C# - ").append(cSharp)
                .append(". Data - ").append(data).append(". DevOps - ")
                .append(devOps).append(". Business - ").append(business)
                .append(" )").append("\n");

        System.out.println(sb);
        sb.setLength(0);

    }

    public void displayTrainingTrainees(ArrayList<TrainingCentre> openCentres) {
        int waitingJava = 0, waitingCSharp = 0, waitingData = 0, waitingDevOps = 0, waitingBusiness = 0;

        for (TrainingCentre centre : openCentres) {

            ArrayList<Trainee> trainees = centre.getTrainees();

            for (Trainee t : trainees) {
                switch (t.getCourseType()) {
                    case JAVA -> waitingJava++;
                    case C_SHARP -> waitingCSharp++;
                    case DATA -> waitingData++;
                    case DEVOPS -> waitingDevOps++;
                    case BUSINESS -> waitingBusiness++;
                }
            }
        }

        sb.append("Training trainees: Java - ")
                .append(waitingJava).append(". C# - ").append(waitingCSharp).append(". Data - ").append(waitingData)
                .append(". DevOps - ").append(waitingDevOps).append(". Business - ").append(waitingBusiness);

        System.out.println(sb);
        sb.setLength(0);

    }

    public void displayWaitingTrainees(ArrayList<Trainee> waitingTrainees) {
        int waitingJava = 0, waitingCSharp = 0, waitingData = 0, waitingDevOps = 0, waitingBusiness = 0;

        for (Trainee t: waitingTrainees){
            switch (t.getCourseType()) {
                case JAVA -> waitingJava++;
                case C_SHARP -> waitingCSharp++;
                case DATA -> waitingData++;
                case DEVOPS -> waitingDevOps++;
                case BUSINESS -> waitingBusiness++;
            }
        }

        sb.append("Waiting trainees: Java - ")
                .append(waitingJava).append(". C# - ").append(waitingCSharp).append(". Data - ").append(waitingData)
                .append(". DevOps - ").append(waitingDevOps).append(". Business - ").append(waitingBusiness);

        System.out.println(sb);
        sb.setLength(0);

    }

    public void displayBenchedTrainees(ArrayList<Trainee> benchedTrainees) {
        int benchJava = 0, benchCSharp = 0, benchData = 0, benchDevOps = 0, benchBusiness = 0;

        for (Trainee t: benchedTrainees){
            switch (t.getCourseType()) {
                case JAVA -> benchJava++;
                case C_SHARP -> benchCSharp++;
                case DATA -> benchData++;
                case DEVOPS -> benchDevOps++;
                case BUSINESS -> benchBusiness++;
            }
        }

        sb.append("Benched trainees: Java - ")
                .append(benchJava).append(". C# - ").append(benchCSharp).append(". Data - ").append(benchData)
                .append(". DevOps - ").append(benchDevOps).append(". Business - ").append(benchBusiness).append("\n");

        System.out.println(sb);
        sb.setLength(0);
    }

    public void displayClientTypes(ArrayList<Client> clients) {

        int clientJava = 0, clientCSharp = 0, clientData = 0, clientDevOps = 0, clientBusiness = 0;

        for (Client c: clients){
            switch (c.getTraineeTypeRequirement()) {
                case JAVA -> clientJava++;
                case C_SHARP -> clientCSharp++;
                case DATA -> clientData++;
                case DEVOPS -> clientDevOps++;
                case BUSINESS -> clientBusiness++;
            }
        }

        sb.append("Client types: Java - ")
                .append(clientJava).append(". C# - ").append(clientCSharp).append(". Data - ").append(clientData)
                .append(". DevOps - ").append(clientDevOps).append(". Business - ").append(clientBusiness);

        System.out.println(sb);
        sb.setLength(0);

    }

    public void displayTraineesWithClient(ArrayList<Client> clients) {

        int traineeJava = 0, traineeCSharp = 0, traineeData = 0, traineeDevOps = 0, traineeBusiness = 0;

        for (Client c: clients) {
            for (Trainee t : c.getTrainees()) {
                switch (t.getCourseType()) {
                    case JAVA -> traineeJava++;
                    case C_SHARP -> traineeCSharp++;
                    case DATA -> traineeData++;
                    case DEVOPS -> traineeDevOps++;
                    case BUSINESS -> traineeBusiness++;
                }
            }
        }

        sb.append("Client trainees: Java - ")
                .append(traineeJava).append(". C# - ").append(traineeCSharp).append(". Data - ").append(traineeData)
                .append(". DevOps - ").append(traineeDevOps).append(". Business - ").append(traineeBusiness);

        System.out.println(sb);
        sb.setLength(0);

    }

    public void displayFinishedMsg(int months) {
        System.out.println("\nMonth " + (months) + ":");
    }
}

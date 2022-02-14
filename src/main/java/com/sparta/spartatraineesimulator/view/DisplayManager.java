package com.sparta.spartatraineesimulator.view;

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


    public String displayTheDetails(int numberOfOpenCentres, int numberOfFullCentres,
                                  int numberOfTraineesCurrentlyTraining, int numberOfTraineesOnTheWaitingList){

        String output = "The current total number of open centres is "+ numberOfOpenCentres +". The number of full centres is "+ numberOfFullCentres +
                ". The number of trainees in training is "+ numberOfTraineesCurrentlyTraining +". And finally the total of trainees on the waiting list is "+ numberOfTraineesOnTheWaitingList +".";

        return output;
    }
}

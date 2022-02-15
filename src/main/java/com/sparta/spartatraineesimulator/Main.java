package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.view.DisplayManager;

public class Main {

    private static int currentMonth;

    public static void main(String[] args) {
        System.out.println("Hello");
        DisplayManager dm = new DisplayManager();
        Controller controller = new Controller();

        int months = dm.numberOfMonths();

        for(int i = 0; i < months; i++) {

            controller.runSimulationTick(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentMonth++;

        }

    }

}

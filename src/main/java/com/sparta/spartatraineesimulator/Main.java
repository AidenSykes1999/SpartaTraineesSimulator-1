package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.view.DisplayManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        DisplayManager dm = new DisplayManager();
        Controller controller = new Controller();
        int months = dm.numberOfMonths();
        controller.runSimulation(months);
    }

}

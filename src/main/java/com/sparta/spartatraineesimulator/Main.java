package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        Controller controller = new Controller();
        controller.runSimulation(12);
    }

}

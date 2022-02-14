package com.sparta.spartatraineesimulator.controller;

// tick stuff

import com.sparta.spartatraineesimulator.model.Centre;
import com.sparta.spartatraineesimulator.model.Trainee;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private int traineeId = 0;
    private ArrayList<Centre> centres;
    private ArrayList<Trainee> trainees = new ArrayList<>();

    public void runSimulation(int month) {
        for(int i = 0; i < month; i++){
            generateTrainees();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 month passed");
            if(i % 2 == 0){
                centres.add(new Centre());
            }
            for(int k = 0; k < centres.size(); k++){
                centres.get(k).setTrainees
            }
            for(int j = 0; j < trainees.size(); i++){
                while(trainees.get(j).getTrainingTime() < )
                trainees.get(j).incrementTrainingTime();
            }
        }
    }

    public ArrayList<Trainee> generateTrainees(){
        Random r = new Random();
        int numberOfTrainees = r.nextInt(50, 101);
        for(int i = 0; i < numberOfTrainees; i++){
            trainees.add(new Trainee(traineeId, 0));
            traineeId++;
        }
        return trainees;
    }
}

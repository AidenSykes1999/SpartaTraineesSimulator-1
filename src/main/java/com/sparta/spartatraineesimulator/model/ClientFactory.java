package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.Random;

public class ClientFactory {
    private ArrayList<Client> happyClients = new ArrayList<>();
    private ArrayList<Client> unhappyClients = new ArrayList<>();
    private ArrayList<Client> recruitingClients = new ArrayList<>();
    private int clientIdCounter;

    public void createClient(){
        Random r = new Random();
        clientIdCounter++;
        recruitingClients.add(new Client(clientIdCounter, Course.randomCourseType(), r.nextInt(15, 51)));
    }

    public void addTraineesToClients(ArrayList<Trainee> bench){
        for (int i = 0; i <= recruitingClients.size(); i++){
            Random r = new Random();
            int numberOfTraineesToRecruit = r.nextInt(1, recruitingClients.get(i).getTraineeNumberRequirement()+1);
            for (int j = 0; j < bench.size(); j++){
                if (bench.get(j).getCourseType() == recruitingClients.get(j).getTraineeTypeRequirement() && recruitingClients.get(j).getTrainees().size() < numberOfTraineesToRecruit){
                    recruitingClients.get(j).setTrainees(bench.get(j));
                }
            }
        }
    }

    public void updateRecruitingClients(){
        for (int i = 0; i <= recruitingClients.size(); i++){
            recruitingClients.get(i).incrementMonths();
            if (recruitingClients.get(i).getMonths() < 12 && recruitingClients.get(i).getTrainees().size() == recruitingClients.get(i).getTraineeNumberRequirement()){
                recruitingClients.get(i).setHappy(true);
                happyClients.add(recruitingClients.get(i));
                recruitingClients.remove(recruitingClients.get(i));
                recruitingClients.get(i).resetMonths();
            }
            else if (recruitingClients.get(i).getMonths() >= 12 && recruitingClients.get(i).getTrainees().size() < recruitingClients.get(i).getTraineeNumberRequirement()){
                recruitingClients.get(i).setHappy(false);
                unhappyClients.add(recruitingClients.get(i));
                recruitingClients.remove(recruitingClients.get(i));
                recruitingClients.get(i).resetMonths();
            }
        }
    }

    public void updateHappyClients(){
        for (int i = 0; i <= happyClients.size(); i++){
            happyClients.get(i).incrementMonths();
            if (happyClients.get(i).getMonths() == 12){
                happyClients.get(i).setHappy(false);
                recruitingClients.add(happyClients.get(i));
                happyClients.remove(happyClients.get(i));
                happyClients.get(i).resetMonths();
            }
        }
    }

    public ArrayList<Client> getHappyClients() {
        return happyClients;
    }

    public ArrayList<Client> getUnhappyClients() {
        return unhappyClients;
    }

    public ArrayList<Client> getRecruitingClients() {
        return recruitingClients;
    }
}

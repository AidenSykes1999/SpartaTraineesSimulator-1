package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;
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

    public void displayClients() {

        System.out.println("Clients Capacity: ");
        for (Client client : recruitingClients) {
            System.out.print(client.getTrainees().size() + " (" + client.getTraineeNumberRequirement() + ")" + ", ");
        }

    }

    public void addTraineesToClients(ArrayList<Trainee> bench){
        ArrayList<Trainee> traineesFromDesiredCourse = new ArrayList<>();
        for (Client client: recruitingClients){
            if (client.getTrainees().size() < client.getTraineeNumberRequirement()) {
                traineesFromDesiredCourse.clear();
                for (Trainee benchedTrainee: bench){
                    if (benchedTrainee.getCourseType() == client.getTraineeTypeRequirement()){
                        traineesFromDesiredCourse.add(benchedTrainee);
                    }
                }
                Random r = new Random();
                int freeSpace = r.nextInt(1,(client.getTraineeNumberRequirement() - client.getTrainees().size()) + 1);
                List<Trainee> addedTrainees = traineesFromDesiredCourse.subList(0, freeSpace);
                client.setTrainees(addedTrainees);
                if (bench.size() > addedTrainees.size()) {
                    bench.removeAll(addedTrainees);
                }
                else{
                    bench.clear();
                }
            }
        }
    }

    public void updateRecruitingClients(){
        for (int i = 0; i < recruitingClients.size(); i++){
            if (recruitingClients.get(i).getMonths() < 12 && recruitingClients.get(i).getTrainees().size() == recruitingClients.get(i).getTraineeNumberRequirement()){
//                recruitingClients.get(i).setHappy(true);
                happyClients.add(recruitingClients.get(i));
                recruitingClients.get(i).resetMonths();
                recruitingClients.remove(recruitingClients.get(i));
            }
            else if (recruitingClients.get(i).getMonths() >= 12 && recruitingClients.get(i).getTrainees().size() < recruitingClients.get(i).getTraineeNumberRequirement()){
//                recruitingClients.get(i).setHappy(false);
                unhappyClients.add(recruitingClients.get(i));
                recruitingClients.get(i).resetMonths();
                recruitingClients.remove(recruitingClients.get(i));
            }
            else{
                recruitingClients.get(i).incrementMonths();
            }
        }
    }

    public void updateHappyClients(){
        for (int i = 0; i < happyClients.size(); i++){
            if (happyClients.get(i).getMonths() == 12){
//                happyClients.get(i).setHappy(false);
                recruitingClients.add(happyClients.get(i));
                happyClients.get(i).resetMonths();
                happyClients.remove(happyClients.get(i));
            }
            else{
                happyClients.get(i).incrementMonths();
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

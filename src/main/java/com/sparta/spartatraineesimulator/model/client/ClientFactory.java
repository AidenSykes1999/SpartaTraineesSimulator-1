package com.sparta.spartatraineesimulator.model.client;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.Trainee;

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
            System.out.print("ClientID " + client.getClientId() + ": " + client.getTrainees().size() + " (" + client.getTraineeNumberRequirement() + ")" + ", ");
        }

    }

    public void addTraineesToClients(ArrayList<Trainee> bench){

        ArrayList<Trainee> traineesFromDesiredCourse = new ArrayList<>();
        Random r = new Random();

        for (Client client: recruitingClients){

            if (client.getTrainees().size() < client.getTraineeNumberRequirement()) {

                traineesFromDesiredCourse.clear();

                int count = 0;
                for (Trainee benchedTrainee: bench){
                    if (benchedTrainee.getCourseType() == client.getTraineeTypeRequirement()){
                        traineesFromDesiredCourse.add(benchedTrainee);
                    }
                    count++;
                }

                System.out.println("Bench trainee count: " + count);

                int freeSpace = r.nextInt(1,
                        (client.getTraineeNumberRequirement() - client.getTrainees().size()) + 1);

                System.out.println("traineesFromDesiredCourse: " + traineesFromDesiredCourse.size());
                System.out.println("freeSpace: " + freeSpace);
                System.out.println("Bench size: " + bench.size());
                System.out.println("Requirement: " + client.getTraineeNumberRequirement());
                System.out.println("Type: " + client.getTraineeTypeRequirement());

                List<Trainee> addedTrainees = null;

                if (traineesFromDesiredCourse.size() < freeSpace) {
                    addedTrainees = traineesFromDesiredCourse.subList(0, traineesFromDesiredCourse.size());
                } else {
                    addedTrainees = traineesFromDesiredCourse.subList(0, freeSpace);
                }

                // System.out.println(client.getClientId() + " added: " + addedTrainees.size());
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

        ArrayList<Client> removeRecruiting = new ArrayList<>();

        for (Client client : recruitingClients){

            if (client.getMonths() < 12
                    && client.getTrainees().size() == client.getTraineeNumberRequirement()){

                happyClients.add(client);
                // System.out.println("Removed from recruiting: " + client.getClientId());

                client.resetMonths();
                removeRecruiting.add(client);

            }
            else if (client.getMonths() >= 12
                    && client.getTrainees().size() < client.getTraineeNumberRequirement()){

                unhappyClients.add(client);

                client.resetMonths();
                removeRecruiting.add(client);

            }
            else{
                client.incrementMonths();
            }
        }

        recruitingClients.removeAll(removeRecruiting);
    }

    public void updateHappyClients(){

        ArrayList<Client> removeClients = new ArrayList<>();

        for (Client client : happyClients){

            if (client.getMonths() == 12){

                recruitingClients.add(client);
                client.resetMonths();
                client.resetTrainees();

                removeClients.add(client);

            }
            else{
                client.incrementMonths();
            }

        }

        happyClients.removeAll(removeClients);
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

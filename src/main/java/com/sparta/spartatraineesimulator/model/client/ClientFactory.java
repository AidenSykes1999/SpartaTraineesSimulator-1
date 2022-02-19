package com.sparta.spartatraineesimulator.model.client;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientFactory {
    private ArrayList<Client> clients = new ArrayList<>();
    private int clientIdCounter;

    public void createClient(){
        Random r = new Random();
        clientIdCounter++;
        clients.add(new Client(clientIdCounter, Course.randomCourseType(), r.nextInt(15, 51)));
    }

    public void addTraineesToClients(ArrayList<Trainee> bench){

        ArrayList<Trainee> traineesFromDesiredCourse = new ArrayList<>();
        Random r = new Random();

        for (Client client: clients){

            if (client.getTrainees().size() < client.getTraineeNumberRequirement()) {

                traineesFromDesiredCourse.clear();

                for (Trainee benchedTrainee: bench){
                    if (benchedTrainee.getCourseType() == client.getTraineeTypeRequirement()){
                        traineesFromDesiredCourse.add(benchedTrainee);
                    }
                }

                int freeSpace = r.nextInt(1,
                        (client.getTraineeNumberRequirement() - client.getTrainees().size()) + 1);

                List<Trainee> addedTrainees = null;

                if (traineesFromDesiredCourse.size() < freeSpace) {
                    addedTrainees = traineesFromDesiredCourse.subList(0, traineesFromDesiredCourse.size());
                } else {
                    addedTrainees = traineesFromDesiredCourse.subList(0, freeSpace);
                }

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

    public void updateClients() {

        for (int i = 0; i < clients.size(); i++){
            clients.get(i).determineHappiness();
            if (clients.get(i).isHappy()){
                clients.get(i).incrementHappyMonths();
                clients.get(i).resetMonths();
            } else {
                clients.get(i).incrementMonths();
            }
        }

        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).isUnhappy()) {
                clients.remove(i);
            }
        }

        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).isHappy() && clients.get(i).getHappyMonths() == 12){
                clients.get(i).resetMonths();
                clients.get(i).setHappyMonths(0);
                clients.get(i).resetTrainees();
                clients.get(i).setHappy(false);
            }
        }

    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}

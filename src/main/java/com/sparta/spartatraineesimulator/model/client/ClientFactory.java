package com.sparta.spartatraineesimulator.model.client;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.trainee.Trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sparta.spartatraineesimulator.SimulatorMain.logger;

public class ClientFactory {
    private ArrayList<Client> clients = new ArrayList<>();
    private int clientIdCounter;

    public void createClient(){
        Random r = new Random();

        clients.add(new Client(clientIdCounter, Course.randomCourseType(), r.nextInt(15, 51)));

        clientIdCounter++;

        logger.debug("Creating client id: " + clientIdCounter);
    }

    public void addTraineesToClients(ArrayList<Trainee> bench){

        ArrayList<Trainee> traineesFromDesiredCourse = new ArrayList<>();
        Random r = new Random();

        for (Client client: clients){

            if (client.getTrainees().size() < client.getTraineeNumberRequirement()) {

                logger.debug("Adding trainees to client ID: " + client.getClientId());

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

        logger.info("Updating clients status...");

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

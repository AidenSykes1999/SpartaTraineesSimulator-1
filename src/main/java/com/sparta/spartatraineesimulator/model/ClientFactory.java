package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientFactory {

    private ArrayList<Client> clients = new ArrayList<>();

    private int clientIdCounter;

    public void createClient(){
        clientIdCounter++;
        clients.add(new Client(clientIdCounter));
    }

    public void addTraineesToClients(ArrayList<Trainee> bench){

        Random random = new Random();

        for (Client client : clients) {

            if (!client.isFull()) {

                System.out.println("Attempting to add");

                ArrayList<Trainee> traineeAddList = new ArrayList<>();

                for (Trainee trainee : bench) {

                    if (trainee.getCourseType() == client.getCourseRequirement()) {
                        traineeAddList.add(trainee);
                    }

                }

                int freeSpace = random.nextInt(1,client.getEmptySpace() + 1);

                List<Trainee> addedTrainees = traineeAddList.subList(0, freeSpace);
                client.addAllTrainees(addedTrainees);

                if (traineeAddList == bench) {
                    bench.clear();
                } else {
                    bench.removeAll(addedTrainees);
                }
            }
        }
    }

    public void displayClients() {

        System.out.println("Clients Capacity: ");
        for (Client client : clients) {
            System.out.print(client.getCurrentCapacity() + " (" + client.getTraineeNumberRequirement() + ")" + ", ");
        }

    }

    // public void updateRecruitingClients(){
    //     for (int i = 0; i <= recruitingClients.size(); i++){
    //         recruitingClients.get(i).incrementMonths();
    //         if (recruitingClients.get(i).getMonths() < 12 && recruitingClients.get(i).getTrainees().size() == recruitingClients.get(i).getTraineeNumberRequirement()){
    //             happyClients.add(recruitingClients.get(i));
    //             recruitingClients.remove(recruitingClients.get(i));
    //             recruitingClients.get(i).resetMonths();
    //         }
    //         else if (recruitingClients.get(i).getMonths() >= 12 && recruitingClients.get(i).getTrainees().size() < recruitingClients.get(i).getTraineeNumberRequirement()){
    //             unhappyClients.add(recruitingClients.get(i));
    //             recruitingClients.remove(recruitingClients.get(i));
    //             recruitingClients.get(i).resetMonths();
    //         }
    //     }
    // }
    //
    // public void updateHappyClients(){
    //     for (int i = 0; i <= happyClients.size(); i++){
    //         happyClients.get(i).incrementMonths();
    //         if (happyClients.get(i).getMonths() == 12){
    //             recruitingClients.add(happyClients.get(i));
    //             happyClients.remove(happyClients.get(i));
    //             happyClients.get(i).resetMonths();
    //         }
    //     }
    // }
    //
    // public ArrayList<Client> getHappyClients() {
    //     return happyClients;
    // }
    //
    // public ArrayList<Client> getUnhappyClients() {
    //     return unhappyClients;
    // }
    //
    // public ArrayList<Client> getRecruitingClients() {
    //     return recruitingClients;
    // }
}

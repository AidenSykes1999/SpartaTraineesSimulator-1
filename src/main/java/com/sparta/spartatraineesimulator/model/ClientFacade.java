package com.sparta.spartatraineesimulator.model;

import java.util.ArrayList;

public class ClientFacade {
    public void handleClients(int month, ArrayList<Trainee> bench){
        ClientFactory clientFactory = new ClientFactory();
        if (month != 0 && month >= 12 && month % 3 == 0){
            clientFactory.createClient();
            clientFactory.addTraineesToClients(bench);
            clientFactory.updateRecruitingClients();
            clientFactory.updateHappyClients();
        }
    }
}

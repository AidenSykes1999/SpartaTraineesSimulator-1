package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.client.ClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientFactoryTest {
    @Test
    @DisplayName("Given the method is run, ensure that createClient adds a client to the clients array list.")
    void givenCreateClientMethod_AddsClientToClientsArrayList(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        Assertions.assertNotNull(clientFactory.getClients());
    }

    @Test
    @DisplayName("Given the method is run, ensure that updateClients increments months of the client if they are not happy.")
    void givenUpdateClientsMethod_IncrementsMonthsOfClientsIfTheyAreNotHappy(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.updateClients();
        Assertions.assertEquals(2, clientFactory.getClients().get(0).getMonths());
    }

    @Test
    @DisplayName("Given the method is run, ensure that updateClients does not increment months of the client if they are happy.")
    void givenUpdateClientsMethod_DoesNotIncrementMonthsOfClientsIfTheyAreHappy(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.getClients().get(0).setHappy(true);
        clientFactory.updateClients();
        Assertions.assertEquals(1, clientFactory.getClients().get(0).getMonths());
    }

    @Test
    @DisplayName("Given the method is run 12 times, ensure that updateClients removes the client from the array list.")
    void givenUpdateClientsMethodTwelveTimes_RemovesClientFromTheArrayList(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        for (int i = 0; i < 12; i++){
            clientFactory.updateClients();
        }
        Assertions.assertTrue(clientFactory.getClients().isEmpty());
    }

    @Test
    @DisplayName("Given the method is run, ensure that updateClients does not increment happy months if the client is not happy.")
    void givenUpdateClientsMethod_DoesNotIncrementHappyMonthsIfClientIsNotHappy(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.updateClients();
        Assertions.assertEquals(0, clientFactory.getClients().get(0).getHappyMonths());
    }

    @Test
    @DisplayName("Given the method is run, ensure that updateClients increments happy months if the client is happy.")
    void givenUpdateClientsMethod_IncrementsHappyMonthsIfClientIsHappy(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.getClients().get(0).setHappy(true);
        clientFactory.updateClients();
        Assertions.assertEquals(1, clientFactory.getClients().get(0).getHappyMonths());
    }

    @Test
    @DisplayName("Given the method is run 12 times, ensure that updateClients makes a happy client not happy.")
    void givenUpdateClientsMethodTwelveTimes_MakesHappyClientNotHappy(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.getClients().get(0).setHappy(true);
        for (int i = 0; i < 12; i++) {
            clientFactory.updateClients();
        }
        Assertions.assertFalse(clientFactory.getClients().get(0).isHappy());
    }

    @Test
    @DisplayName("Given the method is run 12 times, ensure that updateClients resets client's months.")
    void givenUpdateClientsMethodTwelveTimes_ResetsClientMonths(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.getClients().get(0).setHappy(true);
        for (int i = 0; i < 12; i++) {
            clientFactory.updateClients();
        }
        Assertions.assertEquals(1, clientFactory.getClients().get(0).getMonths());
    }

    @Test
    @DisplayName("Given the method is run 12 times, ensure that updateClients resets client's happy months.")
    void givenUpdateClientsMethodTwelveTimes_ResetsClientHappyMonths(){
        ClientFactory clientFactory = new ClientFactory();
        clientFactory.createClient();
        clientFactory.getClients().get(0).setHappy(true);
        for (int i = 0; i < 12; i++) {
            clientFactory.updateClients();
        }
        Assertions.assertEquals(0, clientFactory.getClients().get(0).getHappyMonths());
    }
}

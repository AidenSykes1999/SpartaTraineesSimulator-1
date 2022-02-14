package com.sparta.spartatraineesimulator.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DisplayManagerTest {

    DisplayManager dm;

    @BeforeEach
    public void beforeEach(){
        dm = new DisplayManager();
    }

    @Test
    @DisplayName("Given a positive Integer, return the Integer")
    public void givenAPositiveIntegerReturnTheInteger(){
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(5, dm.numberOfMonths());
    }

    @Test
    @DisplayName("Given a negative Integer, return the Integer")
    public void givenANegativeIntegerReturnTwelve(){
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(12, dm.numberOfMonths());
    }

    @Test
    @DisplayName("Given Zero, return the Integer")
    public void givenZeroReturnTwelve(){
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(12, dm.numberOfMonths());
    }

    @Test
    @DisplayName("Given 4 Integer values, return a String displaying the same data in correlation to the StringBuilder")
    public void given4IntegerValuesReturnAStringDisplayingTheSameDataInCorrelationToTheStringBuilder(){
        String expected = "The current total number of open centres is 34. The number of full centres is 33" +
                ". The number of trainees in training is 3389. And finally the total of trainees on the waiting list is 0.";

        Assertions.assertEquals(expected, dm.displayTheDetails(34,33, 3389, 0));
    }

}
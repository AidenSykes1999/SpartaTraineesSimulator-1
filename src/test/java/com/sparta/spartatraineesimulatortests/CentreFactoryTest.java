package com.sparta.spartatraineesimulatortests;

import com.sparta.spartatraineesimulator.model.centre.CentreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentreFactoryTest {
    @Test
    @DisplayName("Given the method is run, ensure that createCenter adds a centre to the openCentres array list.")
    void givenCreateCenter_AddsCentreToOpenCentresArrayList(){
        CentreFactory.clearOpenCentres();
        CentreFactory.createCenter(2);
        Assertions.assertEquals(1, CentreFactory.getOpenCentres().size());
    }

    @Test
    @DisplayName("Given a full centre, adds it to ClosedCentres array list.")
    void givenFullCentre_AddsCentreToClosedCentresArrayList(){
        CentreFactory.createCenter(2);
        CentreFactory.getOpenCentres().get(0).setActiveTime(3);
        CentreFactory.closeCentres();
        Assertions.assertEquals(1, CentreFactory.getClosedCentres().size());
    }

    @Test
    @DisplayName("Given the method is run, ensure that createCenter adds a centre to the openCentres array list only if month is even.")
    void givenCreateCenter_AddsCentreToOpenCentresArrayListOnlyIfMonthIsEven(){
        CentreFactory.clearOpenCentres();
        CentreFactory.createCenter(4);
        CentreFactory.createCenter(2);
        CentreFactory.createCenter(1);
        Assertions.assertEquals(2, CentreFactory.getNumberOfOpenCentres());
    }

    @Test
    @DisplayName("Given the method is run, ensure that getNumberOfFullCentres returns 1 when 1 centre is full.")
    void givenGetNumberOfFullCentres_ReturnsOneWhenOneCentreIsFull(){
        CentreFactory.createCenter(4);
        CentreFactory.getOpenCentres().get(0).setLimit(0);
        Assertions.assertEquals(1, CentreFactory.getNumberOfFullCentres());
    }
}

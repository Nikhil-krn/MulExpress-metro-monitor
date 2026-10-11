package com.practice.kiosk;


import com.practice.kiosk.domain.Train;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class PatchTests {

    @Test
    public void weakTestForUpdateTimingMethod(){

        Train train = Train.builder()
                .trainId(645)
                .trainName("Test Train")
                .scheduledArrivalTime(LocalTime.parse("13:00"))
                .scheduledDepartureTime(LocalTime.parse("12:50"))
                .date("2026-10-31")
                .origin("RVN")
                .destination("WPN")
                .inventory("")
                .build();


    }
}

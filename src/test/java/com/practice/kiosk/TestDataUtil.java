package com.practice.kiosk;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;

import java.time.LocalDateTime;

public final class TestDataUtil {

    private TestDataUtil(){
    }

    public static Train createTestTrain320(){
        return Train.builder()
                .trainName("St Jermiah")
                .trainId(320)
                .origin("BRX")
                .destination("PAD")
                .scheduledArrivalTime(LocalDateTime.parse("2026-10-14T09:00"))
                .scheduledDepartureTime(LocalDateTime.parse("2026-10-14T09:20"))
                .inventory("((((Y*R*F*T*P)*W*Q)R))")
                .build();
    }

    public static Train createTestTrain321(){
        return Train.builder()
                .trainName("The Honsberry")
                .trainId(321)
                .origin("BRX")
                .destination("STH")
                .scheduledArrivalTime(LocalDateTime.parse("2026-10-15T09:00"))
                .scheduledDepartureTime(LocalDateTime.parse("2026-10-15T09:20"))
                .inventory("((((Y*R*F*T*P)*W*Q)R))")
                .build();
    }

    public static Schedule createTestSchedule122(){
        return Schedule.builder().build();
    }
}

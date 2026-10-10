package com.practice.kiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Train {

    private String trainName;

    private int trainId;

    private LocalTime ScheduledDepartureTime;

    private LocalTime ScheduledArrivalTime;

    private String origin;

    private String destination;

    private final String inventory = "((((Y+R+F+T+P)+W+Q)R))";
}

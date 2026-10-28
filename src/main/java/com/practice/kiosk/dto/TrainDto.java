package com.practice.kiosk.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TrainDto(String trainName,
                       Integer trainId,
                       LocalDateTime scheduledDepartureTime,
                       LocalDateTime scheduledArrivalTime,
                       String origin,
                       String destination,
                       String inventory) {

}
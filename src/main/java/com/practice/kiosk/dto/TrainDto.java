package com.practice.kiosk.dto;

import java.time.LocalDateTime;

public record TrainDto(String trainName,
                       Integer trainId,
                       LocalDateTime scheduledDepartureTime,
                       LocalDateTime scheduledArrivalTime,
                       String origin,
                       String destination,
                       String inventory) {

    public static class TrainDtoBuilder{

        private String trainName;
        private int trainId;
        private LocalDateTime scheduledDepartureTime;
        private LocalDateTime scheduledArrivalTime;
        private String origin;
        private String destination;
        private String inventory;

        public TrainDtoBuilder(){}


    }
}
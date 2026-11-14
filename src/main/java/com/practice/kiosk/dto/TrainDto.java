package com.practice.kiosk.dto;

import java.time.LocalTime;

public record TrainDto( String trainName,
                        Integer trainId,
                        String origin,
                        String destination,
                        String inventory,
                        LocalTime timing) {

}
package com.practice.kiosk.controllers;


import com.practice.kiosk.domain.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TrainController {

    private static final Logger log = LoggerFactory.getLogger(TrainController.class);


    @PostMapping(path = "/trains")
    public Train createTrain(@RequestBody Train train){

        log.info("Got Train: {}", train.toString());
        return new Train();
    }

    @GetMapping(path = "/trains/645")
    public Train samplePOCTrain(){

        return Train.builder()
                .trainName("MLK Express")
                .trainId(645)
                .origin("PAD")
                .destination("BED")
                .scheduledDepartureTime(LocalDateTime.parse("2026-10-31T12:50"))
                .scheduledArrivalTime(LocalDateTime.parse("2026-10-31T13:00"))
                .build();
    }



}

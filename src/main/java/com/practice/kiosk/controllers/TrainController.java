package com.practice.kiosk.controllers;


import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.TrainDto;
import com.practice.kiosk.services.TrainServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private static final Logger log = LoggerFactory.getLogger(TrainController.class);

    private final TrainServices trainServices;

    public TrainController(TrainServices trainServices){
        this.trainServices = trainServices;
    }

    @PostMapping
    public ResponseEntity<TrainDto> createTrain(@RequestBody final TrainDto trainDto){

        log.info("Got Train: {}", trainDto.toString());

        TrainDto newTrain = trainServices.createTrain(trainDto);
        return ResponseEntity.ok(newTrain);
    }

    @GetMapping("/{trainId}")
    public ResponseEntity<TrainDto> getTrainById(@PathVariable("trainId") final Integer trainId){
        TrainDto train = trainServices.getTrainById(trainId);
        return ResponseEntity.ok(train);
    }

    @GetMapping(path = "/trains/645")
    public Train samplePOCTrain(){

        return Train.builder()
                .trainName("MLK Express")
                .trainId(645)
                .origin("PAD")
                .destination("BED")
                .build();
    }



}

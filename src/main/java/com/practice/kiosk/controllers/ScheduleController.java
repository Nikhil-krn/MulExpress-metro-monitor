package com.practice.kiosk.controllers;


import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ScheduleController {

    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
    private final Map<String, Schedule> realTimeSchedule = new ConcurrentHashMap<>();
    //private final String err404 = HttpStatus.NOT_FOUND;


    @GetMapping(path = "/schedules/645")
    public Schedule samplePOCSchedule(){

        return Schedule.builder()
                .boardPoint("PAD")
                .offPoint("BED")
                .date(LocalDate.parse("2026-10-31"))
                .timing(LocalTime.parse("13:00"))
                .fareLevel("ST")
                .build();
    }

    @GetMapping(path = "/trains/645")
    public Train samplePOCTrain(){

        return Train.builder()
                .trainName("MLK Express")
                .trainId(645)
                .origin("PAD")
                .destination("BED")
                //.scheduledDepartureTime()
                //.scheduledArrivalTime()
                .build();
    }

    @GetMapping(path = "/schedules")
    public Schedule retrieveSchedule(@RequestBody final Train train){

        return Schedule.builder()
                .boardPoint("LON")
                .offPoint("ZYR")
                .train(train)
                .date(LocalDate.parse("2026-10-31"))
                .timing(LocalTime.parse("13:00"))
                .fareLevel("ST")
                .build();
    }

    @PostMapping(path = "/schedules")
    public Schedule createSchedule(@RequestBody final Schedule schedule){

        log.info("Got schedule: " + schedule.toString());
        return schedule;
    }

    @PatchMapping(path = "/schedules/{trainId}")
    public Schedule updateTiming(@PathVariable String trainId, @RequestParam LocalTime newTiming){

        Schedule existingSchedule = realTimeSchedule.get(trainId);

        if(existingSchedule == null){
            log.info("404 NOT_FOUND - No schedules found for: {} ", trainId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No schedule for " + trainId);
        }

        if(newTiming.equals(existingSchedule.getTiming())){
            return existingSchedule;
        }

        Train iropTrain = existingSchedule.getTrain() == null ? null : existingSchedule.getTrain().copy();

        if(iropTrain != null){
            iropTrain.setScheduledArrivalTime(LocalDateTime.from(newTiming));
        }

        Schedule updatedSchedule = existingSchedule.withTiming(newTiming);

        //check to see if schedule swapping happened as expected,
        //if yes return normally
        //if no then throqm some exception since probably some other request disrupted concurrency
        if(!realTimeSchedule.replace(trainId, existingSchedule, updatedSchedule)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Schedule was changed concurrently");
        }

        log.info("Changed arrival/departure time of train: {} to: {}", trainId, newTiming );

        return updatedSchedule;
    }


}
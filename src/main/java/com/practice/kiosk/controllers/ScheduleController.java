package com.practice.kiosk.controllers;


import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ScheduleController {

    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
    private final Map<String, Schedule> realTimeSchedule = new ConcurrentHashMap<>();
    private final Map<String, Train> irregularTrain = new ConcurrentHashMap<>();
    //private final String err404 = HttpStatus.NOT_FOUND;


    @GetMapping(path = "/schedule")
    public Schedule retrieveSchedule(){

        return Schedule.builder()
                .boardPoint("LON")
                .offPoint("ZYR")
                .date("2026-10-31")
                .timing(LocalTime.parse("13:00"))
                .fareLevel("ST")
                .build();
    }

    @PostMapping(path = "/schedule")
    public Schedule createSchedule(@RequestBody final Schedule schedule){

        log.info("Got schedule: " + schedule.toString());
        return schedule;
    }

    @PatchMapping(path = "/schedule/{trainId}")
    public Schedule updateTiming(@PathVariable String trainId, @RequestParam LocalTime newTiming){

        //THERE IS NO CHECK to see if old timing and new timing was the same
        Schedule existingSchedule = realTimeSchedule.get(trainId);
        Train train = irregularTrain.get(trainId);

        //check to see if the train in question has an existing schedule
        if(existingSchedule == null){
            log.info("404 NOT_FOUND - No schedules found for: " + trainId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No schedule for " + trainId);
        }
        Schedule updatedSchedule = new Schedule(existingSchedule.getBoardPoint(), existingSchedule.getOffPoint(), train, existingSchedule.getDate(), existingSchedule.getTiming(), existingSchedule.getFareLevel());


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
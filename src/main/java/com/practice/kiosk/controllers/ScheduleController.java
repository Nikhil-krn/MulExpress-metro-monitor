package com.practice.kiosk.controllers;


import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.repositories.ScheduleRepository;
import com.practice.kiosk.services.ScheduleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(path = "/schedules")
public class ScheduleController {

    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);

    private final ScheduleServices scheduleServices;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleServices scheduleServices, ScheduleRepository scheduleRepository){
        this.scheduleServices = scheduleServices;
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody final ScheduleDto scheduleDto){
        log.info("Got schedule: {} ", scheduleDto.toString());

        ScheduleDto newSchedule = scheduleServices.createSchedule(scheduleDto);
        return ResponseEntity.ok(newSchedule);
    }

    @GetMapping(path = "/{scheduleId}")
    public ResponseEntity<ScheduleDto> retrieveSchedule(@PathVariable("scheduleId") final Integer scheduleId){

        ScheduleDto schedule = scheduleServices.retrieveSchedule(scheduleId);
        return ResponseEntity.ok(schedule);
    }

    /*@PatchMapping(path = "/{trainId}")
    public Schedule updateTiming(@PathVariable("trainId") String trainId, @RequestParam LocalTime newTiming){


        Iterable<Schedule> existingSchedules = scheduleRepository.fetchByTrainId(trainId);

        if(existingSchedules == null){
            log.info("404 NOT_FOUND - No schedules found for: {} ", trainId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No schedule for " + trainId);
        }

        if(newTiming.equals(existingSchedules.get(0).getTiming())){
            log.info("No change in timing could be found. {}", newTiming);
            return existingSchedules;
        }

        Train iropTrain = existingSchedules.getTrain() == null ? null : existingSchedules.getTrain().copy();

        if(iropTrain != null){
            iropTrain.setScheduledArrivalTime(LocalDateTime.from(newTiming));
        }

        Schedule updatedSchedule = existingSchedules.withTiming(newTiming);

        //check to see if schedule swapping happened as expected,
        //if yes return normally
        //if no then throqm some exception since probably some other request disrupted concurrency
        if(!realTimeSchedule.replace(trainId, existingSchedules, updatedSchedule)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Schedule was changed concurrently");
        }

        log.info("Changed arrival/departure time of train: {} to: {}", trainId, newTiming );

        return updatedSchedule;
    }*/

    @GetMapping(path = "/645")
    public Schedule samplePOCSchedule(){

        return Schedule.builder()
                .boardPoint("PAD")
                .offPoint("BED")
                .date(LocalDate.parse("2026-10-31"))
                .timing(LocalTime.parse("13:00"))
                .fareLevel("ST")
                .build();
    }

}
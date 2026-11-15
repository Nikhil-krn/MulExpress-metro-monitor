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

    public ScheduleController(ScheduleServices scheduleServices){
        this.scheduleServices = scheduleServices;
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

    @PatchMapping(path = "/{trainId}")
    public ResponseEntity<ScheduleDto> updateTiming( @PathVariable final Integer trainId,
                                                     @RequestParam("newTiming") final LocalDateTime estimatedTime){

        ScheduleDto updatedSchedule = scheduleServices.updateTiming(trainId, estimatedTime);
        return ResponseEntity.ok(updatedSchedule);
    }

}
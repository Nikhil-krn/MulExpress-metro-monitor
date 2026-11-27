package com.practice.kiosk.controllers;

import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.dto.TempDto;
import com.practice.kiosk.dto.UpdateTimingReq;
import com.practice.kiosk.services.ScheduleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @GetMapping(path = "/train")
    public ResponseEntity<TempDto> fetchScheduleId(@RequestParam("trainId") final Integer trainId){
        TempDto id = scheduleServices.fetchScheduleId(trainId);
        return ResponseEntity.ok(id);
    }

    @PatchMapping(path = "/{scheduleId}")
    public ResponseEntity<ScheduleDto> updateTiming(@PathVariable final Integer scheduleId, @RequestBody final UpdateTimingReq request){
        ScheduleDto updatedSchedule = scheduleServices.updateTiming(scheduleId, request);
        return ResponseEntity.ok(updatedSchedule);
    }

}
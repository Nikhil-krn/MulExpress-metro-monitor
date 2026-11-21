package com.practice.kiosk.services;

import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.dto.UpdateTimingReq;

import java.time.LocalDateTime;

public interface ScheduleServices {

    ScheduleDto createSchedule(ScheduleDto scheduleDto);
    ScheduleDto retrieveSchedule(Integer scheduleId);
    ScheduleDto updateTiming(Integer scheduleId, UpdateTimingReq req);
    //ScheduleDto updateTiming(Integer scheduleId, );
    int fetchScheduleId(Integer trainId);
}

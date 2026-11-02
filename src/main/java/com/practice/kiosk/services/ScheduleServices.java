package com.practice.kiosk.services;

import com.practice.kiosk.dto.ScheduleDto;
import java.time.LocalTime;

public interface ScheduleServices {

    ScheduleDto createSchedule(ScheduleDto scheduleDto);
    ScheduleDto retrieveSchedule(Integer scheduleId);
    ScheduleDto updateTiming(Integer trainId, LocalTime newTiming);
}

package com.practice.kiosk.mapper;


import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ScheduleMapper {

    public ScheduleDto toDto(Schedule schedule){
        return new ScheduleDto( schedule.getBoardPoint(),
                                schedule.getOffPoint(),
                                schedule.getTrain(),
                                schedule.getDate(),
                                schedule.getTiming(),
                                schedule.getFareLevel());
    }

    public Schedule toEntity(ScheduleDto scheduleDto){
        return Schedule.builder()
                .boardPoint(scheduleDto.boardPoint())
                .offPoint(scheduleDto.offPoint())
                .date(scheduleDto.date())
                .train(scheduleDto.train())
                .timing(scheduleDto.timing())
                .fareLevel(scheduleDto.fareLevel())
                .build();
    }
}

package com.practice.kiosk.mapper;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import org.springframework.stereotype.Component;


@Component
public class ScheduleMapper {

    public ScheduleDto toDto(Schedule schedule){
        return new ScheduleDto( schedule.getBoardPoint(),
                                schedule.getOffPoint(),
                                schedule.getTrain(),
                                schedule.getScheduledDepartureTime(),
                                schedule.getScheduledArrivalTime(),
                                schedule.getFareLevel());
    }

    public Schedule toEntity(ScheduleDto scheduleDto){
        return Schedule.builder()
                .boardPoint(scheduleDto.boardPoint())
                .offPoint(scheduleDto.offPoint())
                .scheduledDepartureTime(scheduleDto.scheduledDepartureTime())
                .train(scheduleDto.train())
                .scheduledArrivalTime(scheduleDto.scheduledArrivalTime())
                .fareLevel(scheduleDto.fareLevel())
                .build();
    }
}

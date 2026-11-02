package com.practice.kiosk.services.impl;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.exceptions.ResourceNotFoundException;
import com.practice.kiosk.mapper.ScheduleMapper;
import com.practice.kiosk.repositories.ScheduleRepository;
import com.practice.kiosk.repositories.TrainRepository;
import com.practice.kiosk.services.ScheduleServices;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ScheduleServicesImpl implements ScheduleServices {

    private final ScheduleRepository scheduleRepository;
    private final TrainRepository trainRepository;
    private final ScheduleMapper mapper;

    public ScheduleServicesImpl(ScheduleRepository scheduleRepository, TrainRepository trainRepository, ScheduleMapper mapper) {
        this.scheduleRepository = scheduleRepository;
        this.trainRepository = trainRepository;
        this.mapper = mapper;
    }

    @Override
    public ScheduleDto createSchedule(ScheduleDto scheduleDto) {
        Schedule newSchedule = mapper.toEntity(scheduleDto);
        Schedule savedNewSchedule = scheduleRepository.save(newSchedule);
        return mapper.toDto(savedNewSchedule);
    }

    @Override
    public ScheduleDto retrieveSchedule(Integer scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule with id: " + scheduleId + " not found"));
        return mapper.toDto(schedule);
    }

    @Override
    public ScheduleDto updateTiming(Integer trainId, LocalTime newTiming){

        final Map<Integer, Schedule> realTimeSchedule = new ConcurrentHashMap<>();
        //realTimeSchedule.get(trainId);

        return null;
    }
}
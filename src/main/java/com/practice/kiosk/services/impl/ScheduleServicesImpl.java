package com.practice.kiosk.services.impl;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.exceptions.ResourceNotFoundException;
import com.practice.kiosk.mapper.ScheduleMapper;
import com.practice.kiosk.repositories.ScheduleRepository;
import com.practice.kiosk.repositories.TrainRepository;
import com.practice.kiosk.services.ScheduleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleServicesImpl implements ScheduleServices {

    private final ScheduleRepository scheduleRepository;
    private final TrainRepository trainRepository;
    private final ScheduleMapper mapper;

    private final static Logger log = LoggerFactory.getLogger(ScheduleServicesImpl.class);
    
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
    public ScheduleDto updateTiming(Integer trainId, LocalDateTime estimatedArrivalTime){
        Schedule existingSchedule = scheduleRepository.fetchByTrainId(trainId);

        if(existingSchedule == null){
            throw new ResourceNotFoundException("404");
        }

        existingSchedule.setScheduledArrivalTime(estimatedArrivalTime);
        log.info("Changed arrival time of train: {} to: {}", trainId, estimatedArrivalTime );
        
        return mapper.toDto(existingSchedule) ;
    }
}
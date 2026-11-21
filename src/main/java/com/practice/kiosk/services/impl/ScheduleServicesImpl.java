package com.practice.kiosk.services.impl;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.ScheduleDto;
import com.practice.kiosk.dto.UpdateTimingReq;
import com.practice.kiosk.exceptions.ResourceNotFoundException;
import com.practice.kiosk.mapper.ScheduleMapper;
import com.practice.kiosk.repositories.ScheduleRepository;
import com.practice.kiosk.repositories.TrainRepository;
import com.practice.kiosk.services.ScheduleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
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
    public ScheduleDto updateTiming(Integer scheduleId, UpdateTimingReq request){
        //null check
        if(request.date() == null && request.departureTime() == null && request.arrivalTime() == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nothing to update");
        }

        //Use repository methods to find correct schedule
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found!"));

        LocalDateTime dep = schedule.getScheduledDepartureTime();
        LocalDateTime arr = schedule.getScheduledArrivalTime();

        if(request.date() != null){
            long days = ChronoUnit.DAYS.between(dep.toLocalDate(), request.date());
            dep = dep.plusDays(days);
            arr = arr.plusDays(days);
        }

        if (request.departureTime() != null) dep = dep.with(request.departureTime());
        if (request.arrivalTime() != null)   arr = arr.with(request.arrivalTime());

        if(request.departureTime() != null || request.arrivalTime() != null){
            if(arr.isBefore(dep)) arr = arr.plusDays(1);
        }

        schedule.setScheduledDepartureTime(dep);
        schedule.setScheduledArrivalTime(arr);
        scheduleRepository.save(schedule);

        log.info("Changed timing of train: {} \n departure: {} \n arrival: {}", schedule.getTrain().getTrainId(), dep, arr);
        
        return mapper.toDto(schedule);
    }

    @Override
    public int fetchScheduleId(Integer trainId){
        return scheduleRepository.fetchScheduleId(trainId);
    }
}
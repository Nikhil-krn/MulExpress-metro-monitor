package com.practice.kiosk.services.impl;

import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.TrainDto;
import com.practice.kiosk.mapper.TrainMapper;
import com.practice.kiosk.repositories.TrainRepository;
import com.practice.kiosk.services.TrainServices;
import com.practice.kiosk.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrainServicesImpl implements TrainServices {

    private final TrainRepository trainRepository;
    private final TrainMapper trainMapper;

    public TrainServicesImpl(TrainRepository trainRepository, TrainMapper trainMapper){
        this.trainRepository = trainRepository;
        this.trainMapper = trainMapper;
    }

    @Override
    public TrainDto createTrain(TrainDto trainDto){
        Train newtrain = trainMapper.toEntity(trainDto);
        Train savedNewTrain = trainRepository.save(newtrain);
        return trainMapper.toDto(savedNewTrain);
    }

    @Override
    public TrainDto getTrainById(Integer trainId) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train with id: " + trainId + " not found"));
        return trainMapper.toDto(train);
    }

}

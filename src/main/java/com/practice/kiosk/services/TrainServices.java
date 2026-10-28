package com.practice.kiosk.services;

import com.practice.kiosk.dto.TrainDto;

public interface TrainServices {

    TrainDto createTrain(TrainDto trainDto);

    TrainDto getTrainById(Integer trainId);

}

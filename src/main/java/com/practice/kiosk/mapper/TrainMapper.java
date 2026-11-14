package com.practice.kiosk.mapper;


import com.practice.kiosk.domain.Train;
import com.practice.kiosk.dto.TrainDto;
import org.springframework.stereotype.Component;

@Component
public class TrainMapper {


    public TrainDto toDto(Train train){
        return new TrainDto(train.getTrainName(),
                            train.getTrainId(),
                            train.getOrigin(),
                            train.getDestination(),
                            train.getInventory(),
                            train.getTiming());
    }

    public Train toEntity(TrainDto trainDto){
        return Train.builder()
                .trainId(trainDto.trainId())
                .trainName(trainDto.trainName())
                .origin(trainDto.origin())
                .destination(trainDto.destination())
                .inventory(trainDto.inventory())
                .timing(trainDto.timing())
                .build();
    }
}

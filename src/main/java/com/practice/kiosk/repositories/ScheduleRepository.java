package com.practice.kiosk.repositories;

import com.practice.kiosk.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query( value = "SELECT * FROM mxpress_schedules WHERE train_Id = :trainId and happening = TRUE",
            nativeQuery = true )
    Schedule fetchByTrainId(Integer trainId);

}
package com.practice.kiosk.repositories;

import com.practice.kiosk.domain.Schedule;
import com.practice.kiosk.dto.TempDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query( value = "SELECT * FROM mxpress_schedules WHERE train_Id = :trainId and is_happening = TRUE",
            nativeQuery = true )
    Schedule fetchByTrainId(Integer trainId);

    @Query(value = "SELECT schedule_id FROM mxpress_schedules WHERE train_Id = :trainId and is_happening = TRUE",
            nativeQuery = true )
    Integer fetchScheduleId(Integer trainId);

}
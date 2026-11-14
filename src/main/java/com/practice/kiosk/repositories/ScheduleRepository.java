package com.practice.kiosk.repositories;

import com.practice.kiosk.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "SELECT ms FROM mxpress_schedules ms WHERE ms.trainId = :trainId", nativeQuery = true)
    Iterable<Schedule> fetchByTrainId(String trainId);

    @Query(value = "INSERT into mxpress_schedules ms WHERE ms.", nativeQuery = true)
    Schedule saveSchedule(Schedule schedule);
}

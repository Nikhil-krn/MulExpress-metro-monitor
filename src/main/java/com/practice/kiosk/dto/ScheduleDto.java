package com.practice.kiosk.dto;

import com.practice.kiosk.domain.Train;
import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleDto(
        String boardPoint,
        String offPoint,
        Train train,
        LocalDate date,
        LocalTime timing,
        String fareLevel
) {
}

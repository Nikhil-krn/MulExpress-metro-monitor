package com.practice.kiosk.dto;

import com.practice.kiosk.domain.Train;
import java.time.LocalDateTime;

public record ScheduleDto(
        String boardPoint,
        String offPoint,
        Train train,
        LocalDateTime scheduledDepartureTime,
        LocalDateTime scheduledArrivalTime,
        String fareLevel
) {
}

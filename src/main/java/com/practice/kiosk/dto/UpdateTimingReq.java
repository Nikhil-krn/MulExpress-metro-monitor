package com.practice.kiosk.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateTimingReq(LocalDate date, LocalTime departureTime, LocalTime arrivalTime) {

}
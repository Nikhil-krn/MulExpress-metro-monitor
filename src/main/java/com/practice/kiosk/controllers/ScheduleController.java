package com.practice.kiosk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.practice.kiosk.domain.Schedule;

public class ScheduleController {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
	
	
	@GetMapping(path = "/schedules")
	public Schedule retrieveSchedules() {
		return Schedule.builder()
				.boardPoint("AYT")
				.offPoint("FRA")
				.date("Monday")
				.timing("13:00")
				.fareLevel("ST")
				.build();
	}
	
	
	@PostMapping(path = "/schedules")
	public Schedule createSchedules(@RequestBody final Schedule schedule) {
		log.info("Acquired schedule: " + schedule.toString());
		return schedule;
	}

}

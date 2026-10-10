package com.practice.kiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

	private String boardPoint;
	
	private String offPoint;
	
	private String date;
	
	private String timing;
	
	private String fareLevel;
	
	
}

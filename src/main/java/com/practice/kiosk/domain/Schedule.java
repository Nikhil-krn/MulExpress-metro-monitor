package com.practice.kiosk.domain;

import java.time.LocalTime;

public class Schedule {

	private String boardPoint;
	
	private String offPoint;

	Train train = null;
	
	private String date;
	
	//private String timing;
	private LocalTime timing;
	
	private String fareLevel;
	
	public Schedule(String boardPoint, String offPoint, Train train, String date, LocalTime timing, String fareLevel){

		this.boardPoint = boardPoint;
		this.offPoint = offPoint;
		this.train = train;
		this.date = date;
		this.timing = timing;
		this.fareLevel = fareLevel;
	}

	//void setTrain()

	/*Train getTrain(){
		return this.train;
	}
	 */

}

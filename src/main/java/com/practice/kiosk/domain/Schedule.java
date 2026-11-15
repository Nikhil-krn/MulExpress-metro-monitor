package com.practice.kiosk.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "mxpress_schedules")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_id_seq")
	private Integer scheduleId;
	private String boardPoint;
	private String offPoint;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trainId")
	private Train train;
	private LocalDateTime scheduledDepartureTime;
	private LocalDateTime scheduledArrivalTime;
	private String fareLevel;
	private boolean happening = false;

	public Schedule() {}

	public Schedule(String boardPoint, String offPoint, Train train,
					LocalDateTime scheduledDepartureTime, LocalDateTime scheduledArrivalTime, String fareLevel) {
		this.boardPoint = boardPoint;
		this.offPoint = offPoint;
		this.train = train;
		this.scheduledDepartureTime = scheduledDepartureTime;
		this.scheduledArrivalTime = scheduledArrivalTime;
		this.fareLevel = fareLevel;
	}

	//Setters
	public void setBoardPoint(String boardPoint) { this.boardPoint = boardPoint; }
	public void setOffPoint(String offPoint)     { this.offPoint = offPoint; }
	public void setTrain(Train train)            { this.train = train; }
	public void setScheduledDepartureTime(LocalDateTime scheduledDepartureTime)	{ this.scheduledDepartureTime = scheduledDepartureTime; }
	public void setScheduledArrivalTime(LocalDateTime scheduledArrivalTime)		{ this.scheduledArrivalTime = scheduledArrivalTime; }
	public void setFareLevel(String fareLevel)   { this.fareLevel = fareLevel; }
	public void setHappening(boolean happening)	 { this.happening = happening; }

	// Getters
	public Integer getScheduleId(){	return scheduleId;}
	public String getBoardPoint() { return boardPoint; }
	public String getOffPoint()   { return offPoint; }
	public Train getTrain()       { return train; }
	public LocalDateTime getScheduledDepartureTime()	{ return scheduledDepartureTime; }
	public LocalDateTime getScheduledArrivalTime()  		{ return scheduledArrivalTime; }
	public String getFareLevel()  { return fareLevel; }
	public boolean getHappening() { return this.happening;}

	//withers
	public Schedule withDepartureTiming(LocalDateTime estimatedDepartureTime) {
		Schedule updatedSchedule = new Schedule(boardPoint, offPoint, train, estimatedDepartureTime, scheduledArrivalTime, fareLevel);
		updatedSchedule.setHappening(true);
		return updatedSchedule;
	}

	// Builder
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String boardPoint;
		private String offPoint;
		private Train train;
		private LocalDateTime scheduledDepartureTime;
		private LocalDateTime scheduledArrivalTime;
		private String fareLevel;

		private Builder() {}

		public Builder boardPoint(String boardPoint) { this.boardPoint = boardPoint; return this; }
		public Builder offPoint(String offPoint)     { this.offPoint = offPoint; return this; }
		public Builder train(Train train)            { this.train = train; return this; }
		public Builder scheduledDepartureTime(LocalDateTime scheduledDepartureTime)	{ this.scheduledDepartureTime = scheduledDepartureTime; return this; }
		public Builder scheduledArrivalTime(LocalDateTime scheduledArrivalTime)		{ this.scheduledArrivalTime = scheduledArrivalTime; return this; }
		public Builder fareLevel(String fareLevel)   { this.fareLevel = fareLevel; return this; }

		public Schedule build() {
			return new Schedule(boardPoint, offPoint, train, scheduledDepartureTime, scheduledArrivalTime, fareLevel);
		}
	}

	// equals / hashCode / toString
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Schedule other)) return false;
		return Objects.equals(boardPoint, other.boardPoint)
				&& Objects.equals(offPoint, other.offPoint)
				&& Objects.equals(train, other.train)
				&& Objects.equals(scheduledDepartureTime, other.scheduledDepartureTime)
				&& Objects.equals(scheduledArrivalTime, other.scheduledArrivalTime)
				&& Objects.equals(fareLevel, other.fareLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardPoint, offPoint, train, scheduledDepartureTime, scheduledArrivalTime, fareLevel);
	}

	@Override
	public String toString() {
		return "Schedule{boardPoint=" + boardPoint
				+ ", offPoint=" + offPoint
				+ ", train=" + train
				+ ", scheduledDepartureTime =" + scheduledDepartureTime
				+ ", scheduledArrivalTime =" + scheduledArrivalTime
				+ ", fareLevel=" + fareLevel + "}";
	}

}
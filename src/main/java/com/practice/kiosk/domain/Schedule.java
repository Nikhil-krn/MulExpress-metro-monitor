package com.practice.kiosk.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule {

	private String boardPoint;
	private String offPoint;
	private Train train;
	private LocalDate date;
	private LocalTime timing;
	private String fareLevel;

	public Schedule() {}

	public Schedule(String boardPoint, String offPoint, Train train,
					LocalDate date, LocalTime timing, String fareLevel) {
		this.boardPoint = boardPoint;
		this.offPoint = offPoint;
		this.train = train;
		this.date = date;
		this.timing = timing;
		this.fareLevel = fareLevel;
	}

	// Setters
	public void setBoardPoint(String boardPoint) { this.boardPoint = boardPoint; }
	public void setOffPoint(String offPoint)     { this.offPoint = offPoint; }
	public void setTrain(Train train)            { this.train = train; }
	public void setDate(LocalDate date)             { this.date = date; }
	public void setTiming(LocalTime timing)      { this.timing = timing; }
	public void setFareLevel(String fareLevel)   { this.fareLevel = fareLevel; }

	// Getters
	public String getBoardPoint() { return boardPoint; }
	public String getOffPoint()   { return offPoint; }
	public Train getTrain()       { return train; }
	public LocalDate getDate()       { return LocalDate.from(date); }
	public LocalTime getTiming()  { return timing; }
	public String getFareLevel()  { return fareLevel; }

	//withers
	public Schedule withTiming(LocalTime newTiming) {
		return new Schedule(boardPoint, offPoint, train, date, newTiming, fareLevel);
	}

	// Builder
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String boardPoint;
		private String offPoint;
		private Train train;
		private LocalDate date;
		private LocalTime timing;
		private String fareLevel;

		private Builder() {}

		public Builder boardPoint(String boardPoint) { this.boardPoint = boardPoint; return this; }
		public Builder offPoint(String offPoint)     { this.offPoint = offPoint; return this; }
		public Builder train(Train train)            { this.train = train; return this; }
		public Builder date(LocalDate date)             { this.date = date; return this; }
		public Builder timing(LocalTime timing)      { this.timing = timing; return this; }
		public Builder fareLevel(String fareLevel)   { this.fareLevel = fareLevel; return this; }

		public Schedule build() {
			return new Schedule(boardPoint, offPoint, train, date, timing, fareLevel);
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
				&& Objects.equals(date, other.date)
				&& Objects.equals(timing, other.timing)
				&& Objects.equals(fareLevel, other.fareLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardPoint, offPoint, train, date, timing, fareLevel);
	}

	@Override
	public String toString() {
		return "Schedule{boardPoint=" + boardPoint
				+ ", offPoint=" + offPoint
				+ ", train=" + train
				+ ", date=" + date
				+ ", timing=" + timing
				+ ", fareLevel=" + fareLevel + "}";
	}

}
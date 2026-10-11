package com.practice.kiosk.domain;

import java.time.LocalDateTime;
import java.util.Objects;


public class Train {

    private String trainName;

    private int trainId;

    private LocalDateTime scheduledDepartureTime;

    private LocalDateTime scheduledArrivalTime;

    private String origin;

    private String destination;

    private String inventory;

    public Train(String trainName, int trainId, LocalDateTime scheduledArrivalTime,
                 LocalDateTime scheduledDepartureTime, String origin,
                 String destination, String inventory){
        this.trainName = trainName;
        this.trainId = trainId;
        this.scheduledArrivalTime = scheduledArrivalTime;
        this.scheduledDepartureTime = scheduledDepartureTime;
        this.origin = origin;
        this.destination = destination;
        this.inventory = "((((Y+R+F+T+P)+W+Q)R))";
    }

    public Train(){
        this.trainName = "Open Train-xxx";
        this.inventory = "((((Y+R+F+T+P)+W+Q)R))";
    }

    //setters
    public void setTrainName(String trainName){
        this.trainName = trainName;
    }

    public void setTrainId(int trainId){
        this.trainId = trainId;
    }

    public void setScheduledArrivalTime(LocalDateTime scheduledArrivalTime){
        this.scheduledArrivalTime = scheduledArrivalTime;
    }

    public void setScheduledDepartureTime(LocalDateTime scheduledDepartureTime){
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    //getters
    public int getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public LocalDateTime getScheduledArrivalTime() {
        return scheduledArrivalTime;
    }

    public LocalDateTime getScheduledDepartureTime(){
        return scheduledDepartureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getInventory() {
        return inventory;
    }

    //Train class builder
    public static class TrainBuilder{

        private String trainName;
        private int trainId;
        private LocalDateTime scheduledDepartureTime;
        private LocalDateTime scheduledArrivalTime;
        private String origin;
        private String destination;
        private String inventory;

        public TrainBuilder(){}

        public TrainBuilder trainName(String trainName)     { this.trainName = trainName; return this; }

        public TrainBuilder trainId(int trainId)            { this.trainId = trainId; return this; }

        public TrainBuilder scheduledArrivalTime(LocalDateTime scheduledArrivalTime)    { this.scheduledArrivalTime = scheduledArrivalTime; return this; }

        public TrainBuilder scheduledDepartureTime(LocalDateTime scheduledDepartureTime){ this.scheduledDepartureTime = scheduledDepartureTime; return this; }

        public TrainBuilder origin(String origin)           { this.origin = origin; return this;}

        public TrainBuilder destination(String destination) { this.destination = destination; return this; }

        public TrainBuilder inventory(String inventory)     {this.inventory = inventory; return this; }

        public Train build(){
            return new Train(trainName, trainId, scheduledArrivalTime, scheduledDepartureTime, origin, destination, inventory);
        }

        @Override
        public String toString(){
            return "Train.TrainBuilder{trainName =" + trainName
                    + ", trainId = " + trainId
                    + ", scheduledArrivalTime= " + scheduledArrivalTime
                    + ", scheduledDepartureTime= " + scheduledDepartureTime
                    + ", origin= " + origin
                    + ", destination= " + destination
                    + ", inventory= " + inventory + "}";
        }

    }

    public static TrainBuilder builder(){
        return new TrainBuilder();
    }

    public Train copy() {
        Train t = new Train();
        t.setTrainName(trainName);
        t.setTrainId(trainId);
        t.setScheduledArrivalTime(scheduledArrivalTime);
        t.setScheduledDepartureTime(scheduledDepartureTime);
        t.setOrigin(origin);
        t.setDestination(destination);
        t.setInventory(inventory);
        return t;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){ return true;}
        if (!(o instanceof Train other)){
            return false;
        }
        return Objects.equals(trainName, other.trainName)
                && Objects.equals(trainId, other.trainId)
                && Objects.equals(scheduledArrivalTime, other.scheduledArrivalTime)
                && Objects.equals(scheduledDepartureTime, other.scheduledDepartureTime)
                && Objects.equals(origin, other.origin)
                && Objects.equals(destination, other.destination)
                && Objects.equals(inventory, other.inventory);

    }

    @Override
    public int hashCode(){
        return Objects.hash(trainName, trainName, scheduledArrivalTime, scheduledDepartureTime, origin, destination, inventory);
    }

    @Override
    public String toString(){
        return "Train{trainName =" + trainName
                + ", trainId = " + trainId
                + ", scheduledArrivalTime= " + scheduledArrivalTime
                + ", scheduledDepartureTime= " + scheduledDepartureTime
                + ", origin= " + origin
                + ", destination= " + destination
                + ", inventory= " + inventory + "}";
    }

}
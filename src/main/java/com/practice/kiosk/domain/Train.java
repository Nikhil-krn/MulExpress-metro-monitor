package com.practice.kiosk.domain;

import java.time.LocalTime;


public class Train {

    private String trainName;

    private int trainId;

    private LocalTime scheduledDepartureTime;

    private LocalTime scheduledArrivalTime;

    private String date;

    private String origin;

    private String destination;

    private String inventory;

    public Train(String trainName, int trainId, LocalTime scheduledArrivalTime,
                 LocalTime scheduledDepartureTime, String date, String origin,
                 String destination, String inventory){
        this.trainName = trainName;
        this.trainId = trainId;
        this.scheduledArrivalTime = scheduledArrivalTime;
        this.scheduledDepartureTime = scheduledDepartureTime;
        this.date = date;
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

    public void setScheduledArrivalTime(LocalTime scheduledArrivalTime){
        this.scheduledArrivalTime = scheduledArrivalTime;
    }

    public void setScheduledDepartureTime(LocalTime scheduledDepartureTime){
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public void setDate(String date){
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public LocalTime getScheduledArrivalTime() {
        return scheduledArrivalTime;
    }

    public LocalTime getScheduledDepartureTime(){
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
        private LocalTime scheduledDepartureTime;
        private LocalTime scheduledArrivalTime;
        private String date;
        private String origin;
        private String destination;
        private String inventory;

        public TrainBuilder(){}

        public TrainBuilder trainName(String trainName){
            this.trainName = trainName;
            return this;
        }

        public TrainBuilder trainId(int trainId){
            this.trainId = trainId;
            return this;
        }

        public TrainBuilder scheduledArrivalTime(LocalTime scheduledArrivalTime){
            this.scheduledArrivalTime = scheduledArrivalTime;
            return this;
        }

        public TrainBuilder scheduledDepartureTime(LocalTime scheduledDepartureTime){
            this.scheduledDepartureTime = scheduledDepartureTime;
            return this;
        }

        public TrainBuilder date(String date){
            this.date = date;
            return this;
        }

        public TrainBuilder origin(String origin){
            this.origin = origin;
            return this;
        }

        public TrainBuilder destination(String destination){
            this.destination = destination;
            return this;
        }

        public TrainBuilder inventory(String inventory){
            this.inventory = inventory;
            return this;
        }

        public Train build(){
            return new Train(trainName, trainId, scheduledArrivalTime, scheduledDepartureTime, date, origin, destination, inventory);
        }

        @Override
        public String toString(){
            return "Train.TrainBuilder(trainName =" + trainName + ", trainId = " + trainId + ", scheduledArrivalTime= "
                    + scheduledArrivalTime + ", scheduledDepartureTime= " + scheduledDepartureTime + ", date= " + date + ", origin= "
                    + origin + ", destination= " + destination + ", inventory= " + inventory + ")";
        }

    }

    public static TrainBuilder builder(){
        return new TrainBuilder();
    }
}
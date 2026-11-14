package com.practice.kiosk.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "mxpress_trains")
public class Train {

    private String trainName;
    @Id
    private Integer trainId;
    private String origin;
    private String destination;
    private String inventory;
    private LocalTime timing;

    public Train(String trainName, int trainId, String origin,
                 String destination, String inventory, LocalTime timing){
        this.trainName = trainName;
        this.trainId = trainId;
        this.origin = origin;
        this.destination = destination;
        this.inventory = "((((Y+R+F+T+P)+W+Q)R))";
        this.timing = timing;
    }

    public Train(){
        this.trainName = "Open Train - xxx";
        this.inventory = "((((Y+R+F+T+P)+W+Q)R))";
    }

    //setters
    public void setTrainName(String trainName)      { this.trainName = trainName; }
    public void setTrainId(int trainId)             { this.trainId = trainId; }
    public void setOrigin(String origin)            { this.origin = origin; }
    public void setDestination(String destination)  { this.destination = destination; }
    public void setInventory(String inventory)      { this.inventory = inventory; }
    public void setTiming(LocalTime timing)         { this.timing = timing; }

    //getters
    public int getTrainId()         { return trainId; }
    public String getTrainName()    { return trainName; }
    public String getOrigin()       { return origin; }
    public String getDestination()  { return destination; }
    public String getInventory()    { return inventory; }
    public LocalTime getTiming()    { return timing; }

    //Train class builder
    public static class TrainBuilder{

        private String trainName;
        private int trainId;
        private String origin;
        private String destination;
        private String inventory;
        private LocalTime timing;

        public TrainBuilder(){}

        public TrainBuilder trainName(String trainName)     { this.trainName = trainName; return this; }
        public TrainBuilder trainId(int trainId)            { this.trainId = trainId; return this; }
        public TrainBuilder origin(String origin)           { this.origin = origin; return this;}
        public TrainBuilder destination(String destination) { this.destination = destination; return this; }
        public TrainBuilder inventory(String inventory)     { this.inventory = inventory; return this; }
        public TrainBuilder timing(LocalTime timing)        { this.timing = timing; return this; }

        public Train build(){
            return new Train(trainName, trainId, origin, destination, inventory, timing);
        }

        @Override
        public String toString(){
            return "Train.TrainBuilder{trainName =" + trainName
                    + ", trainId = " + trainId
                    + ", origin= " + origin
                    + ", destination= " + destination
                    + ", inventory= " + inventory
                    + ", timing= " + timing + "}";
        }

    }

    public static TrainBuilder builder(){
        return new TrainBuilder();
    }

    public Train copy() {
        Train t = new Train();
        t.setTrainName(this.trainName);
        t.setTrainId(this.trainId);
        t.setOrigin(this.origin);
        t.setDestination(this.destination);
        t.setInventory(this.inventory);
        t.setTiming(this.timing);
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
                && Objects.equals(origin, other.origin)
                && Objects.equals(destination, other.destination)
                && Objects.equals(inventory, other.inventory)
                && Objects.equals(timing, other.timing);

    }

    @Override
    public int hashCode(){
        return Objects.hash(trainName, trainName, origin, destination, inventory, timing);
    }

    @Override
    public String toString(){
        return "Train{trainName =" + trainName
                + ", trainId = " + trainId
                + ", origin= " + origin
                + ", destination= " + destination
                + ", inventory= " + inventory
                + ", timing= " + timing + "}";
    }

}
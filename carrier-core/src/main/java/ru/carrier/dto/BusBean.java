package ru.carrier.dto;

import ru.carrier.entity.Bus;

/**
 * Created by User on 17.04.2014.
 */
public class BusBean {
    private Long id;
    private String stateNumber;
    private Integer seats;
    private String busModel;

    public BusBean(Long id, String stateNumber, Integer seats, String busModel) {
        this.id = id;
        this.stateNumber = stateNumber;
        this.seats = seats;
        this.busModel = busModel;
    }

    public BusBean(Bus bus) {
        this.id = bus.getId();
        this.stateNumber = bus.getStateNumber();
        this.seats = bus.getSeats();
        this.busModel = bus.getBusModel();
    }

    public BusBean() {
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    @Override
    public String toString() {
        return "BusBean{" +
                "stateNumber='" + stateNumber + '\'' +
                ", seats=" + seats +
                ", busModel='" + busModel + '\'' +
                '}';
    }
}

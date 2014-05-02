package ru.carrier.dto;

import java.util.List;

/**
 * Created by User on 17.04.2014.
 */
public class CarrierBusesBean {

    String carrierName;

    List<BusBean> buses;

    public CarrierBusesBean(String carrierName, List<BusBean> buses) {
        this.carrierName = carrierName;
        this.buses = buses;
    }

    public CarrierBusesBean() {
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public List<BusBean> getBuses() {
        return buses;
    }

    public void setBuses(List<BusBean> buses) {
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "CarrierBusesBean{" +
                "carrierName='" + carrierName + '\'' +
                ", buses=" + buses +
                '}';
    }
}

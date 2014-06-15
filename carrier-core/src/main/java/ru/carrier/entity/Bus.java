package ru.carrier.entity;

import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 19.03.14.
 */
@Table(name = "bus")
@Entity
public class Bus extends AbstractEntityImpl implements Serializable {

    @Column(name = "state_number")
    private String stateNumber;

    @Column(name = "seats")
    private Integer seats;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusModelSpr.class)
    @JoinColumn(name = "bus_model_id")
    private BusModelSpr busModelSpr;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusBrandSpr.class)
    @JoinColumn(name = "bus_brand_id")
    private BusBrandSpr busBrandSpr;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Carrier.class)
    @JoinColumn(name = "carrier_man_id")
    private Carrier carrier;

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

    public BusModelSpr getBusModelSpr() {
        return busModelSpr;
    }

    public void setBusModelSpr(BusModelSpr busModelSpr) {
        this.busModelSpr = busModelSpr;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}

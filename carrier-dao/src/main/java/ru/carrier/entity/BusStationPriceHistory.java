package ru.carrier.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by User on 20.03.14.
 */
@Entity(name = "station_price_history")
public class BusStationPriceHistory extends AbstractPersistable<Long> {

    @Column(name = "start_period")
    private Date startPeriod;

    @Column(name = "end_period")
    private Date endPeriod;

    @Column(name = "forward_price")
    private BigDecimal forwardDirectionPrice;

    @Column(name = "opposite_price")
    private BigDecimal oppositeDirectionPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusStation.class)
    @JoinColumn(name = "bus_station_id")
    private BusStation busStation;

    public BusStationPriceHistory() {
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public BigDecimal getForwardDirectionPrice() {
        return forwardDirectionPrice;
    }

    public void setForwardDirectionPrice(BigDecimal forwardDirectionPrice) {
        this.forwardDirectionPrice = forwardDirectionPrice;
    }

    public BigDecimal getOppositeDirectionPrice() {
        return oppositeDirectionPrice;
    }

    public void setOppositeDirectionPrice(BigDecimal oppositeDirectionPrice) {
        this.oppositeDirectionPrice = oppositeDirectionPrice;
    }
}

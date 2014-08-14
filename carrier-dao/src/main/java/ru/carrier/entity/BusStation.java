package ru.carrier.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 20.03.14.
 */
@Entity(name = "bus_station")
public class BusStation extends AbstractPersistable<Long> {

    @Column(name = "station_name")
    private String stationName;

    @OneToMany(targetEntity = BusStationPriceHistory.class, mappedBy = "busStation", fetch = FetchType.LAZY)
    private List<BusStationPriceHistory> stationPriceHistories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusRoute.class)
    @JoinColumn(name = "bus_route_id")
    private BusRoute busRoute;

    public BusStation() {
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<BusStationPriceHistory> getStationPriceHistories() {
        return stationPriceHistories;
    }

    public void setStationPriceHistories(List<BusStationPriceHistory> stationPriceHistories) {
        this.stationPriceHistories = stationPriceHistories;
    }
}


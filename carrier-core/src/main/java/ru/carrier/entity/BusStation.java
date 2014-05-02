package ru.carrier.entity;

import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 20.03.14.
 */
@Table(name = "bus_station")
@Entity
public class BusStation extends AbstractEntityImpl implements Serializable {

    @Column(name = "station_name")
    private String stationName;

    @OneToMany(targetEntity = BusStationPriceHistory.class, mappedBy = "busStation", fetch = FetchType.LAZY)
    private List<BusStationPriceHistory> stationPriceHistories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusRoute.class)
    @JoinColumn(name = "bus_route_id")
    private BusRoute busRoute;

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


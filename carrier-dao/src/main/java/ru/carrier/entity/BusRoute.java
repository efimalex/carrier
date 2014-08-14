package ru.carrier.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 20.03.14.
 */
@Entity(name = "bus_route")
public class BusRoute extends AbstractPersistable<Long> {

    @Column(name = "route_number")
    private String routeNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Bus.class)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @OneToMany(targetEntity = BusStation.class, mappedBy = "busRoute", fetch = FetchType.LAZY)
    private Set<BusStation> stationList;

    @OneToMany(targetEntity = Timetable.class, mappedBy = "busRoute", fetch = FetchType.LAZY)
    private Set<Timetable> timetables;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusStation.class)
    @JoinColumn(name = "dispatch_station_id")
    private BusStation dispatchStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusStation.class)
    @JoinColumn(name = "destination_station_id")
    private BusStation destinationStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Carrier.class)
    @JoinColumn(name = "carrier_man_id")
    private Carrier carrier;

    public BusRoute() {
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Set<BusStation> getStationList() {
        return stationList;
    }

    public void setStationList(Set<BusStation> stationList) {
        this.stationList = stationList;
    }

    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }

    public BusStation getDispatchStation() {
        return dispatchStation;
    }

    public void setDispatchStation(BusStation dispatchStation) {
        this.dispatchStation = dispatchStation;
    }

    public BusStation getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(BusStation destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void addTimetableUnit(final Timetable timetable){
        timetables.add(timetable);
    }

    public void addStation(final BusStation station){
        stationList.add(station);
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}

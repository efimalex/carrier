package ru.carrier.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 07.04.2014.
 */

@Entity(name = "carrier_man")
public class Carrier extends AbstractPersistable<Long> {

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Bus.class, mappedBy = "carrier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bus> buses;

    @OneToMany(targetEntity = BusRoute.class, mappedBy = "carrier", fetch = FetchType.LAZY)
    private List<BusRoute> routes;

    public Carrier() {
    }

    public void addBusRoute(BusRoute busRoute){
        getRoutes().add(busRoute);
    }

    public void addBus(Bus bus){
        getBuses().add(bus);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bus> getBuses() {
        if (this.buses == null)
            return this.buses = new ArrayList<Bus>();
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public List<BusRoute> getRoutes() {
        if (this.routes == null)
            return this.routes = new ArrayList<>();
        return routes;
    }

    public void setRoutes(List<BusRoute> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", buses=" + buses +
                '}';
    }
}

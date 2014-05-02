package ru.carrier.entity;

import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by User on 20.03.14.
 */
@Table(name = "timetable")
@Entity
public class Timetable extends AbstractEntityImpl implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusRoute.class)
    @JoinColumn(name = "bus_route_id")
    private BusRoute busRoute;

    @Column(name = "date_departure")
    private LocalDate dateDeparture;

    @Column(name = "time_departure")
    private LocalTime timeDeparture;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

}

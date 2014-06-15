package ru.carrier.service;

import ru.carrier.dto.BusBean;
import ru.carrier.dto.CarrierBusesBean;
import ru.carrier.entity.Bus;
import ru.carrier.entity.BusRoute;
import ru.carrier.entity.BusStation;
import ru.carrier.entity.Carrier;

import java.util.List;

/**
 * Created by User on 14.04.2014.
 */
public interface CarrierManagement extends Service<Carrier> {

    void addBusToCarrier(Long carrierId, BusBean addedBus);

    List<BusBean> getCarrierBuses(Long carrierId);

    CarrierBusesBean getBuses(Long carrierId);

    void addBusRoute(Long carrierId, BusRoute busRoute);

    Carrier create(Carrier carrier);
}

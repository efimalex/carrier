package ru.carrier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.carrier.dao.CarrierDao;
import ru.carrier.dao.Dao;
import ru.carrier.dto.BusBean;
import ru.carrier.dto.CarrierBusesBean;
import ru.carrier.entity.Bus;
import ru.carrier.entity.BusRoute;
import ru.carrier.entity.Carrier;
import ru.carrier.service.CarrierManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 14.04.2014.
 */
@Service("carrierManagement")
public class CarrierManagementImpl extends ServiceImpl<Carrier> implements CarrierManagement {

    @Autowired
    private CarrierDao carrierDao;

    @Override
    @Transactional
    public void addBusToCarrier(Long carrierId, BusBean addedBus) {
        Carrier carrier = getCarrier(carrierId);
        Bus bus = getBus(addedBus);
        bus.setCarrier(carrier);
        carrier.addBus(bus);
        getDao().saveOrUpdate(carrier);
    }

    private Bus getBus(BusBean addedBus) {
        Bus bus = new Bus();
        bus.setSeats(addedBus.getSeats());
        bus.setStateNumber(addedBus.getStateNumber());
        //bus.setBusModel(addedBus.getBusModel());
        return bus;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BusBean> getCarrierBuses(Long carrierId){
        return getBusesBeans(getCarrier(carrierId));
    }

    private List<BusBean> getBusesBeans(Carrier carrier) {
        List<BusBean> result = new ArrayList<>();
        for (Bus bus : carrier.getBuses()){
            result.add(new BusBean(bus));
        }
        return result;
    }

    @Override
    public CarrierBusesBean getBuses(Long carrierId) {
        CarrierBusesBean result = new CarrierBusesBean();
        Carrier carrier = getCarrier(carrierId);
        result.setCarrierName(carrier.getShortName());
        result.setBuses(getBusesBeans(carrier));
        return result;
    }

    @Override
    @Transactional
    public void addBusRoute(Long carrierId, BusRoute busRoute) {
        Carrier carrier = getCarrier(carrierId);
        carrier.addBusRoute(busRoute);
        getDao().saveOrUpdate(carrier);
    }

    @Override
    @Transactional
    public Carrier create(Carrier carrier){
        return getDao().saveOrUpdate(carrier);
    }

    private Carrier getCarrier(Long carrierId) {
        return getDao().findById(Carrier.class, carrierId);
    }

    @Override
    protected Dao<Carrier> getDao() {
        return carrierDao;
    }
}

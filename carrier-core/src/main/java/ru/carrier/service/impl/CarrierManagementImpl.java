package ru.carrier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.carrier.dao.CarrierDao;
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
@Service
public class CarrierManagementImpl implements CarrierManagement {

    @Autowired
    private CarrierDao carrierDao;

    @Override
    public Carrier find(Long id) {
        return carrierDao.findById(Carrier.class, id);
    }

    @Override
    @Transactional
    public void addBusToCarrier(Long carrierId, BusBean addedBus) {
        Carrier carrier = getCarrier(carrierId);
        Bus bus = getBus(addedBus);
        bus.setCarrier(carrier);
        carrier.addBus(bus);
        carrierDao.saveOrUpdate(carrier);
    }

    private Bus getBus(BusBean addedBus) {
        Bus bus = new Bus();
        bus.setSeats(addedBus.getSeats());
        bus.setStateNumber(addedBus.getStateNumber());
        bus.setBusModel(addedBus.getBusModel());
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
        carrierDao.saveOrUpdate(carrier);
    }

    @Override
    @Transactional
    public Carrier create(Carrier carrier){
        return carrierDao.saveOrUpdate(carrier);
    }

    @Override
    @Transactional
    public List<Carrier> findAll() {
        return carrierDao.findAll();
    }

    private Carrier getCarrier(Long carrierId) {
        return carrierDao.findById(Carrier.class, carrierId);
    }
}

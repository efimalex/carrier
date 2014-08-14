package ru.carrier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.carrier.service.BusService;
import ru.carrier.entity.Bus;
import ru.carrier.repository.BusRepository;

/**
 * Created by efim on 13.08.14.
 */

public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    @Transactional
    public void createBus(Bus bus) {
        busRepository.save(bus);
    }
}

package ru.carrier.service;

import org.springframework.stereotype.Service;
import ru.carrier.entity.Bus;

/**
 * Created by efim on 13.08.14.
 */
@Service
public interface BusService {

    void createBus(Bus bus);

}

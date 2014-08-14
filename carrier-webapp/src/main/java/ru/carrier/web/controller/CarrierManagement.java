package ru.carrier.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.carrier.entity.Bus;
import ru.carrier.service.BusService;

/**
 * Created by efim on 14.08.14.
 */
@Controller
@RequestMapping("carrier-place")
public class CarrierManagement {

    @Autowired
    private BusService busService;

    @RequestMapping(value = "bus",method = RequestMethod.POST)
    @ResponseBody
    public String saveBus(Bus bus){
        busService.createBus(bus);
        return "Success create BUS";
    }
}

package ru.carrier.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.carrier.JpaTestConfig;
import ru.carrier.dto.BusBean;
import ru.carrier.entity.Bus;
import ru.carrier.entity.Carrier;

/**
 * Created by User on 16.04.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaTestConfig.class})
public class CarrierManagementTest {

//    @Autowired
//    private CarrierManagement carrierManagement;
//
//    @Test
//    public void testCreate() throws Exception {
//        Carrier carrier = new Carrier();
//        carrier.setFullName("ИП Ефимов А.А.");
//        carrier.setShortName("ИП Ефимов А.А.");
//        carrier.setDescription("Description");
//
//        BusBean bus = new BusBean();
//        //bus.setBusModel("Gasel");
//        bus.setSeats(13);
//        bus.setStateNumber("А 555 АА");
//
//        Carrier firstSavedCarrier = carrierManagement.create(carrier);
//        System.out.println("Carrier is create successful");
//        //Carrier loadedCarrier = carrierManagement.find(Carrier.class, firstSavedCarrier.getId());
////        System.out.println(loadedCarrier);
////        carrierManagement.addBusToCarrier(loadedCarrier.getId(), bus);
////        System.out.println("Carrier after added bus");
////        System.out.println(carrierManagement.find(Carrier.class, carrierManagement.create(loadedCarrier).getId()));
//
//    }
}

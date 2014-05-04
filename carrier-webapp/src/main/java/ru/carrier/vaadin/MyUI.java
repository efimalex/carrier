package ru.carrier.vaadin;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.carrier.entity.Carrier;
import ru.carrier.service.CarrierManagement;
import ru.carrier.vaadin.view.CarrierPlace;
import ru.xpoft.vaadin.DiscoveryNavigator;

import java.util.List;

/**
 * Created by User on 21.04.2014.
 */

@Component
@Scope("prototype")
//@Theme("reindeer")
//@Theme("dashboard")


@Title("Carrier manager")
public class MyUI extends UI {

    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
//         List<Carrier> carriers = carrierManagement.findAll();
//        carriers.toString();
//        String str =  applicationContext.getApplicationName();
//        System.out.println(str);
        DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);
        this.setNavigator(navigator);
        this.setContent(new CarrierPlace());
    }
}

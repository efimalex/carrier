package ru.carrier.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.carrier.vaadin.view.carrierside.CarrierPlace;
import ru.xpoft.vaadin.DiscoveryNavigator;

/**
 * Created by User on 21.04.2014.
 */

@Component
@Scope("prototype")
//@Theme("dashboard")
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

package ru.carrier.vaadin;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.carrier.vaadin.view.CarrierPlace;

/**
 * Created by User on 21.04.2014.
 */

@Component("myUI")
@Scope("prototype")
//@Theme("reindeer")
//@Theme("dashboard")


@Title("Carrier manager")
public class MyUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new CarrierPlace());
    }
}

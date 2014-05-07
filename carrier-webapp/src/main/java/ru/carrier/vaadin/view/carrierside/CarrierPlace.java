package ru.carrier.vaadin.view.carrierside;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;
import ru.carrier.entity.Carrier;
import ru.carrier.service.CarrierManagement;
import ru.carrier.utils.SpringContextHelper;
import ru.xpoft.vaadin.VaadinView;

/**
 * Created by User on 22.04.2014.
 */
@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView(CarrierPlace.NAME)
//@Configurable(preConstruction = true, dependencyCheck = true)
public class CarrierPlace extends Panel implements View {

    //    @Autowired
//    protected ApplicationContext applicationContext;
//
//    @Autowired
//    protected CarrierManagement carrierManagement;
    SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());

    public static final String NAME = "";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setContent(initLayout());
    }

    private BeanItemContainer<Carrier> getFillingContainer() {
        BeanItemContainer<Carrier> container = new BeanItemContainer<>(Carrier.class);
        CarrierManagement manager = (CarrierManagement) helper.getBean("carrierManagement");
        manager.findAll().forEach(container::addItem);
        return container;
    }

    private Tree getLeftMenu(){
        Tree menu = new Tree("Доступные компоненты");
        menu.setWidth(150, Unit.PIXELS);
        menu.setStyleName("left-menu");
        return menu;
    }

    private Table getCarrierTable() {
        Table table = new Table("Item detail");
        table.setContainerDataSource(getFillingContainer());
        table.setVisibleColumns(new String[]{"fullName", "description"});
        table.setSizeFull();
        table.addStyleName("borderless");
        table.setWidth(550, Unit.PIXELS);
        return table;
    }

    public CarrierPlace() {

    }

    private Layout initLayout() {
        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label("Рабочее место перевозчика"));

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        content.addComponent(horizontalLayout);
        horizontalLayout.addComponent(getLeftMenu());
        horizontalLayout.addComponent(getCarrierTable());
        horizontalLayout.setSizeFull();
        return content;
    }
}

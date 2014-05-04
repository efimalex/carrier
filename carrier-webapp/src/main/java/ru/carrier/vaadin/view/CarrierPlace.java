package ru.carrier.vaadin.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
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
VerticalLayout vl = new VerticalLayout();

    SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());

    public static final String NAME = "";

    private Table table;

//    @Override
//    protected void init(VaadinRequest request) {
//        setSizeFull();
//        setContent(vl);
//        vl.addComponent(table);
//        vl.setSizeFull();
//        table = new Table("Item detail");
//        table.setContainerDataSource(getFillingContainer());
//        table.setVisibleColumns(new String[]{"fullName", "description"});
//        table.setSizeFull();
//        table.addStyleName("borderless");
//    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        ;
    }

    protected BeanItemContainer<Carrier> getFillingContainer() {
//        String s = applicationContext.getApplicationName();
//        System.out.print(s);
        BeanItemContainer<Carrier> container = new BeanItemContainer<>(Carrier.class);
        CarrierManagement manager = (CarrierManagement) helper.getBean("carrierManagement");
        manager.findAll().forEach(container::addItem);
        return container;
    }

    public CarrierPlace() {
        setSizeFull();
        setContent(vl);

        table = new Table("Item detail");
        table.setContainerDataSource(getFillingContainer());
        table.setVisibleColumns(new String[]{"fullName", "description"});
        table.setSizeFull();
        table.addStyleName("borderless");
        vl.addComponent(table);
        vl.setSizeFull();
       // setSizeFull();

       // VerticalLayout vl = new VerticalLayout(table);
       // vl.setSizeFull();
    }
    //    @Override
//    protected void init(VaadinRequest request) {
//        VerticalLayout content = new VerticalLayout();
//        content.setSizeFull();
//        setContent(content);
//
//        HorizontalLayout hor = new HorizontalLayout();
//        hor.setSizeFull();
//
//        Tree availableItem = new Tree("My tree");
//
//        Table itemDetail = new Table("My table");
//        itemDetail.setSizeFull();
//
//        hor.addComponent(itemDetail);
//        hor.setExpandRatio(itemDetail, 1);
//
//        content.addComponent(hor);
//        content.setExpandRatio(hor, 1);
//
//    }
}

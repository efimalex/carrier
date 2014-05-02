package ru.carrier.vaadin.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import ru.carrier.entity.Carrier;
import ru.carrier.service.CarrierManagement;
import ru.xpoft.vaadin.VaadinView;

/**
 * Created by User on 22.04.2014.
 */
@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView()
public class CarrierPlace extends Panel implements View {

    @Autowired
    private CarrierManagement carrierManagement;

    private Table table;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        ;
    }

    protected BeanItemContainer<Carrier> getFillingContainer() {
        BeanItemContainer<Carrier> container = new BeanItemContainer<>(Carrier.class);
        carrierManagement.findAll().forEach(container::addItem);
        return container;
    }

    public CarrierPlace() {
        setSizeFull();
        table = new Table("Item detail");
        table.setContainerDataSource(getFillingContainer());
        //table.setVisibleColumns(new String[]{"Первая", "Вторая", "Третья"});
        table.setSizeFull();
        table.addStyleName("borderless");
        VerticalLayout vl = new VerticalLayout(table);
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

package ru.carrier.vaadin.view.carrierside;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;
import ru.carrier.entity.Bus;
import ru.carrier.entity.BusBrandSpr;
import ru.carrier.entity.Carrier;
import ru.carrier.entity.SprData;
import ru.carrier.service.SprDataManagement;
import ru.carrier.service.CarrierManagement;
import ru.carrier.utils.SpringContextHelper;
import ru.carrier.vaadin.window.carrierside.edit.EditBus;
import ru.xpoft.vaadin.VaadinView;

import java.util.List;

/**
 * Created by User on 22.04.2014.
 */
@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView(CarrierPlace.NAME)
//@Configurable(preConstruction = true, dependencyCheck = true)
public class CarrierPlace extends Panel implements View {

    private  VerticalLayout content = new VerticalLayout();
    private HorizontalLayout horizontalLayout = new HorizontalLayout();

    private List<SprData> busBrandSprList;

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

    private Panel getLeftMenu(){
        Accordion menu = new Accordion();
//        Label transportCategoryLabel = new Label("Транспорт");
//        Label sprCategoryLabel = new Label("Справочники");
//        Label timetableCategoryLabel = new Label("Расписание");
        Layout transportCategoryItems = new VerticalLayout();
        transportCategoryItems.addComponent(getButton("Показать весь траспорт"));
        transportCategoryItems.addComponent(getButton("Показать задействованные сегодня"));

        Layout sprCategoryItems = new VerticalLayout();
        sprCategoryItems.addComponent(getShowCarrierDetailButton("Справочник моделей авто"));
        sprCategoryItems.addComponent(getButton("Справочник пунктов остановки"));

        Layout timetableCategoryItems = new VerticalLayout();
        timetableCategoryItems.addComponent(getButton("Все расписание"));

        menu.addTab(transportCategoryItems, "Транспорт");
        menu.addTab(sprCategoryItems, "Справочники");
        menu.addTab(timetableCategoryItems, "Расписание");

        Panel panel = new Panel("Категории");
        panel.setWidth("300px");
        //panel.setHeight("500px");
        panel.setContent(menu);

//        menu.setWidth(150, Unit.PIXELS);
        menu.setStyleName("left-menu");
        return panel;
    }

    private Button getShowCarrierDetailButton(String caption){
        Button listenerButton = getButton(caption);
        listenerButton.addClickListener(getCarrierButtonListener());
        return listenerButton;
    }

    private Button getButton(String caption) {
        Button button = new Button(caption);
        //button.addClickListener(getTransportButtonListener());
        button.setSizeFull();
        return button;
    }

    private Button.ClickListener getTransportButtonListener() {
        return event -> new Notification("This is a warning",
                "<br/>This is the <i>last</i> warning",
                Notification.TYPE_ERROR_MESSAGE, true)
                .show(Page.getCurrent());
    }

    private Button.ClickListener getCarrierButtonListener(){
        return new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                initCarrierDetail();
            }
        };
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
        SprDataManagement busSprManagement = (SprDataManagement) helper.getBean("busSprManagement");
        busBrandSprList = busSprManagement.findAll();

    }

    private void initCarrierDetail(){
        horizontalLayout.removeAllComponents();
        horizontalLayout.addComponent(getCarrierTable());
        horizontalLayout.addComponent(createCommandButtons());
    }

    private Layout initLayout() {
        content.addComponent(new Label("Рабочее место перевозчика"));
        content.addComponent(horizontalLayout);
        horizontalLayout.addComponent(getLeftMenu());
//        horizontalLayout.addComponent(getCarrierTable());
        horizontalLayout.setSizeUndefined();
        return content;
    }

    private Layout createCommandButtons() {
        final HorizontalLayout layout = new HorizontalLayout();

        Button addButton = new Button("Создать нового агента");

        addButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                Bus bus = new Bus();
                //agent.setBalance(BigDecimal.ZERO);
                EditBus editBus = new EditBus(bus, busBrandSprList, true);
               // editAgent2.getOkHandler().add(new com.perspective.common.event.Listener<OkClickEditEventArgs<Agent>>() {
//                    @Override
//                    public void invoke(OkClickEditEventArgs<Agent> args) {
//                        EditAgentHandler handler = new EditAgentHandler(getContainer(), agentDAO, true);
//                        handler.setAgentService(agentService);
//                        handler.handle(args.getBean());
//                        getTable().refreshRowCache();
//                        getTable().sort();
//                    }
//                });

                getUI().addWindow(editBus);

            }
        });

        layout.addComponent(addButton);
        layout.setComponentAlignment(addButton, Alignment.MIDDLE_CENTER);

        return layout;
    }
}

package ru.carrier.vaadin.window.carrierside.edit;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.carrier.entity.Bus;
import ru.carrier.entity.BusBrandSpr;

import java.util.List;

/**
 * Created by Саня on 25.05.2014.
 */
public class EditBus extends EditBaseWindow<Bus> {

//    @Autowired
//    private BusSprManagement busSprManagement = ApplicationContextHolder.getBean("busSprManagement");

    private static final Logger LOGGER = LogManager.getLogger(EditBus.class.getName());

    private List<BusBrandSpr> busBrandSprs;

    public EditBus(Bus bean, List<BusBrandSpr> busBrandSprs, boolean isNewItem) {
        super(bean, isNewItem);
        this.busBrandSprs = busBrandSprs;
    }

    @Override
    protected Layout createBody() {
        FormLayout layout = new FormLayout();

        BeanItemContainer<BusBrandSpr> bbs = new BeanItemContainer<>(BusBrandSpr.class);
        //List<BusBrandSpr> brandSprs = busSprManagement.findAll();
        bbs.addAll(busBrandSprs);

        BeanFieldGroup<Bus> binder = getBinder();

        ComboBox comboBox = binder.buildAndBind("Марка автобуса", "busBrandSpr", ComboBox.class);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setContainerDataSource(bbs);

//        comboBox.setItemCaption(AgentStatus.ACTIVE, "Активен");
//        comboBox.setItemCaption(AgentStatus.LOCKED, "Заблокирован");
        comboBox.setItemCaptionMode(AbstractSelect.ItemCaptionMode.EXPLICIT_DEFAULTS_ID);



        Field<?>[] fields = new Field<?>[]{binder.buildAndBind("Гос.номер", "stateNumber"),
                binder.buildAndBind("Количество мест", "seats"),
                comboBox};

        for (Field<?> field : fields) {
            if (field instanceof AbstractTextField) {
                AbstractTextField src = (AbstractTextField) field;
                src.setNullRepresentation("");//TODO: Currently it's a right way, but in normal flow we must choose better way.
            }

            field.setRequired(true);
            field.setRequiredError(String.format("Поле '%s' должно быть непустым.", field.getCaption()));

            layout.addComponent(field);
        }

        layout.addComponent(comboBox);

        if (isNewItem()) {
            layout.addComponent(binder.buildAndBind("Пароль", "password", PasswordField.class));
        }

        return layout;
    }

    @Override
    protected Class<Bus> getBeanType() {
        return Bus.class;
    }

    @Override
    protected String getCaptionNew() {
        return "Новый автобус";
    }

    @Override
    protected String getCaptionEdit() {
        return "Редактирование параметров автобуса";
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

}

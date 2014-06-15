package ru.carrier.vaadin.window.carrierside.edit;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Notification;
import ru.carrier.domain.AppEntity;
import ru.carrier.service.Service;
import ru.carrier.vaadin.window.carrierside.BaseWindow;

/**
 * Created by Саня on 23.05.2014.
 */
public abstract class EditBaseWindow<T extends AppEntity> extends BaseWindow {

    private final static String SAVE_CAPTION = "Сохранить";
    private final static String CREATE_CAPTION = "Создать";
    private final BeanFieldGroup<T> binder;
//    private final BeanItemContainer<T> beanContainer;
//    protected final Service<T> service;
    private boolean isNewItem;

    public EditBaseWindow(final T bean, final boolean isNewItem) {
        super();
        binder = new BeanFieldGroup<T>(getBeanType());
        binder.setItemDataSource(new BeanItem<T>(bean));

        setIsNewItem(isNewItem);
    }

    @Override
    protected void init() {
        super.init();
//        this.setCaption(isNewItem ? getCaptionNew() : getCaptionEdit());
//        this.setButtonOkCaption(isNewItem ? CREATE_CAPTION : SAVE_CAPTION);
    }

    protected abstract Class<T> getBeanType();

    protected abstract String getCaptionNew();

    protected abstract String getCaptionEdit();

    @Override
    protected void onOkClick() throws FieldGroup.CommitException {

        binder.commit();

        T bean = binder.getItemDataSource().getBean();


    }

    protected BeanFieldGroup<T> getBinder() {
        return binder;
    }

    protected boolean isNewItem() {
        return isNewItem;
    }

    protected void setIsNewItem(boolean isNewItem) {
        this.isNewItem = isNewItem;

        this.setCaption(isNewItem ? getCaptionNew() : getCaptionEdit());
        this.setButtonOkCaption(isNewItem ? CREATE_CAPTION : SAVE_CAPTION);
    }

}

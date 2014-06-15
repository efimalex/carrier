package ru.carrier.vaadin.window.carrierside;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Саня on 22.05.2014.
 */
public abstract class BaseWindow extends Window {

    private final static String CANCEL_CAPTION = "Отмена";
    private final AtomicBoolean layoutInitzilized = new AtomicBoolean(false);
    protected Button buttonOk;
    private String buttonOkCaption;
    private boolean buttonOkEnabled = true;


    // protected Logger logger = LogManager.getLogger(BaseWindow.class.getName());

    protected abstract Logger getLogger();

    protected abstract Layout createBody();

    protected abstract void onOkClick() throws FieldGroup.CommitException;

    protected void init() {
        setClosable(false);
        setDraggable(false);
        setResizable(false);
        setModal(true);
        center();
    }

    private Layout initLayout() {
        synchronized (layoutInitzilized) {
            Layout bodyLayout = createBody();
            Layout footer = createFooter();

            VerticalLayout mainLayout = new VerticalLayout();
            VerticalLayout bodyContainer = new VerticalLayout(bodyLayout);


            mainLayout.setMargin(false);
            bodyContainer.setMargin(new MarginInfo(true, true, false, true));

            mainLayout.addComponent(bodyContainer);
            mainLayout.addComponent(footer);

            mainLayout.setComponentAlignment(footer, Alignment.MIDDLE_RIGHT);

            layoutInitzilized.set(true);
            return mainLayout;
        }
    }

    private Layout createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        Layout buttonsPart = createButtonsPart();
        footer.addStyleName("footer");

        footer.setWidth(100, Unit.PERCENTAGE);
        footer.setMargin(true);

        footer.addComponent(buttonsPart);

        footer.setComponentAlignment(buttonsPart, Alignment.MIDDLE_RIGHT);

        return footer;
    }

    private Layout createButtonsPart() {
        HorizontalLayout layout = new HorizontalLayout();

        layout.setSpacing(true);

        Button buttonCancel = createButtonCancel();
        buttonOk = createButtonOk();

        layout.addComponent(buttonCancel);
        layout.addComponent(buttonOk);

        layout.setComponentAlignment(buttonCancel, Alignment.MIDDLE_RIGHT);
        layout.setComponentAlignment(buttonOk, Alignment.MIDDLE_RIGHT);

        return layout;
    }

    protected Button createButtonCancel() {
        Button button = new Button(CANCEL_CAPTION, new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                BaseWindow.this.close();
            }
        });

        button.addStyleName("wide");
        //button.addStyleName("default");

        return button;
    }

    private Button createButtonOk() {
        Button result = new Button();

        result.addStyleName("wide");
        result.addStyleName("default");

        result.setCaption(buttonOkCaption);
        result.setEnabled(buttonOkEnabled);
        result.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    onOkClick();
                    BaseWindow.this.close();
                } catch (FieldGroup.CommitException e) {
                    getLogger().error(e);
                    Notification.show("Ошибка", e.getCause().getMessage(), Notification.Type.ERROR_MESSAGE);

                } catch (Exception e) {
                    getLogger().error(e);

                    if (!(e instanceof NullPointerException)) {
                        Notification.show("Ошибка", e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    } else {
                        Notification.show("Ошибка", "Произошла непредвиденная ошибка. Попытка не удалась", Notification.Type.ERROR_MESSAGE);
                    }
                }
            }
        });

        return result;
    }

    protected void setButtonOkCaption(String caption) {
        synchronized (layoutInitzilized) {
            if (layoutInitzilized.get()) {
                buttonOk.setCaption(caption);
            } else {
                buttonOkCaption = caption;
            }
        }
    }

    protected void setButtonOkEnabled(boolean enabled) {
        synchronized (layoutInitzilized) {
            if (layoutInitzilized.get()) {
                buttonOk.setEnabled(enabled);
            } else {
                buttonOkEnabled = enabled;
            }
        }
    }

    @Override
    public void setParent(HasComponents parent) {
        super.setParent(parent);
        if (parent != null) {
            this.setContent(initLayout());
        }
    }

}

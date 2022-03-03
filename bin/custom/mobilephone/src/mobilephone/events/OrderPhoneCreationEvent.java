package mobilephone.events;

import org.springframework.context.ApplicationEvent;

public class OrderPhoneCreationEvent extends ApplicationEvent {

    private final String phoneID;
    private final int quantity;
    private final String dateCreate;

    public OrderPhoneCreationEvent(Object source, String phoneID, int quantity, String dateCreate) {
        super(source);
        this.phoneID = phoneID;
        this.quantity = quantity;
        this.dateCreate = dateCreate;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDateCreate() {
        return dateCreate;
    }
}

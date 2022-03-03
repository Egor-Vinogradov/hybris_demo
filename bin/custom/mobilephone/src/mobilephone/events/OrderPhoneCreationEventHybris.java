package mobilephone.events;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class OrderPhoneCreationEventHybris extends AbstractEvent {

    private final String phoneID;
    private final int quantity;
    private final String dateCreate;

    public OrderPhoneCreationEventHybris(String phoneID, int quantity, String dateCreate) {
        super();
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

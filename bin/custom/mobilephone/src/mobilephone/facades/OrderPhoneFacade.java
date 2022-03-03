package mobilephone.facades;

import mobilephone.data.OrderPhoneData;

import java.util.List;

public interface OrderPhoneFacade {

    List<OrderPhoneData> getAllOrderPhone();
    OrderPhoneData getOrderPhoneByCode(String code);
    void createOrder(OrderPhoneData item);
}

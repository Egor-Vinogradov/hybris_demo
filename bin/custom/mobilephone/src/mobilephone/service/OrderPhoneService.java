package mobilephone.service;

import mobilephone.data.OrderPhoneData;
import mobilephone.model.OrderPhoneModel;

import java.util.List;

public interface OrderPhoneService {

    List<OrderPhoneModel> findOrdersPhone();
    List<OrderPhoneModel> findOrdersPhoneByCode(String code);
    void createOrderPhone(OrderPhoneData model);
}

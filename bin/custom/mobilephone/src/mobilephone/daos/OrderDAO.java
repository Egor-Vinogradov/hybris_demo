package mobilephone.daos;

import mobilephone.model.OrderPhoneModel;

import java.util.List;

public interface OrderDAO {

    List<OrderPhoneModel> findOrdersPhone();
    List<OrderPhoneModel> findOrdersPhoneByCode(String code);
}

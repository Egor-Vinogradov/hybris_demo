package mobilephone.facades.impl;

import mobilephone.converters.OrderPhoneConverter;
import mobilephone.data.OrderPhoneData;
import mobilephone.facades.OrderPhoneFacade;
import mobilephone.model.OrderPhoneModel;
import mobilephone.service.OrderPhoneService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "orderPhoneFacade")
public class DefaultOrderPhoneFacade implements OrderPhoneFacade {

    private final OrderPhoneService orderPhoneService;
    private final OrderPhoneConverter orderPhoneConverter;


    public DefaultOrderPhoneFacade(OrderPhoneService orderPhoneService,
                                   OrderPhoneConverter orderPhoneConverter) {
        this.orderPhoneService = orderPhoneService;
        this.orderPhoneConverter = orderPhoneConverter;
    }

    @Override
    public List<OrderPhoneData> getAllOrderPhone() {
        List<OrderPhoneModel> orderPhoneModels = this.orderPhoneService.findOrdersPhone();
        List<OrderPhoneData> orderPhoneDataList = new ArrayList<>();
        for (OrderPhoneModel orderPhoneModel : orderPhoneModels) {
            orderPhoneDataList.add(this.orderPhoneConverter.convert(orderPhoneModel));
        }
        return orderPhoneDataList;
    }

    @Override
    public OrderPhoneData getOrderPhoneByCode(String code) {
        List<OrderPhoneModel> orderPhoneModels = this.orderPhoneService.findOrdersPhoneByCode(code);
        return this.orderPhoneConverter.convert(orderPhoneModels.get(0));
    }

    @Override
    public void createOrder(OrderPhoneData item) {
        this.orderPhoneService.createOrderPhone(item);
    }
}

package mobilephone.service;

import mobilephone.model.EventCreatOrderModel;

import java.util.Date;
import java.util.List;

public interface EventCreatOrderService {

    List<EventCreatOrderModel> findEventByData(Date date);
}

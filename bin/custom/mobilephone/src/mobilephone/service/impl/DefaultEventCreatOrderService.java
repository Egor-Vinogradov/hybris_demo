package mobilephone.service.impl;

import mobilephone.daos.EventCreatOrderDAO;
import mobilephone.model.EventCreatOrderModel;
import mobilephone.service.EventCreatOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class DefaultEventCreatOrderService implements EventCreatOrderService {

    private EventCreatOrderDAO eventCreatOrderDAO;

    public void setEventCreatOrderDAO(EventCreatOrderDAO eventCreatOrderDAO) {
        this.eventCreatOrderDAO = eventCreatOrderDAO;
    }

    @Override
    public List<EventCreatOrderModel> findEventByData(Date date) {
        List<EventCreatOrderModel> list = this.eventCreatOrderDAO.findEventByData(date);

//        if (!list.isEmpty()) {}

        return list;
    }
}

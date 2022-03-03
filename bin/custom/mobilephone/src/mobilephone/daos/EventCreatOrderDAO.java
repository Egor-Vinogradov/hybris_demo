package mobilephone.daos;

import mobilephone.model.EventCreatOrderModel;

import java.util.Date;
import java.util.List;

public interface EventCreatOrderDAO {

    List<EventCreatOrderModel> findEventByData(Date data);
}

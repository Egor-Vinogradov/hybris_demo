package mobilephone.service.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import mobilephone.converters.populators.ReverseOrderPhonePopulator;
import mobilephone.daos.OrderDAO;
import mobilephone.data.OrderPhoneData;
import mobilephone.events.OrderPhoneCreationEvent;
import mobilephone.model.OrderPhoneModel;
import mobilephone.service.OrderPhoneService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value = "orderPhoneService")
public class DefaultOrderPhoneService implements OrderPhoneService {

    private final OrderDAO orderDAO;
    private final ModelService modelService;
    private final ReverseOrderPhonePopulator reverseOrderPhonePopulator;

    private final ApplicationEventPublisher eventPublisher;

    public DefaultOrderPhoneService(OrderDAO orderDAO,
                                    ModelService modelService,
                                    ReverseOrderPhonePopulator reverseOrderPhonePopulator, ApplicationEventPublisher eventPublisher) {
        this.orderDAO = orderDAO;
        this.modelService = modelService;
        this.reverseOrderPhonePopulator = reverseOrderPhonePopulator;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<OrderPhoneModel> findOrdersPhone() {
        return this.orderDAO.findOrdersPhone();
    }

    @Override
    public List<OrderPhoneModel> findOrdersPhoneByCode(String code) {
        return this.orderDAO.findOrdersPhoneByCode(code);
    }

    @Override
    public void createOrderPhone(OrderPhoneData model) {
        OrderPhoneModel newOrder = this.modelService.create(OrderPhoneModel.class);
        this.reverseOrderPhonePopulator.populate(model, newOrder);
        newOrder.setDateCreate(new Date());

        this.modelService.save(newOrder);

        this.eventPublisher.publishEvent(new OrderPhoneCreationEvent(newOrder, model.getPhoneID(),
                model.getQuantity(), newOrder.getDateCreate().toString()));
    }
}

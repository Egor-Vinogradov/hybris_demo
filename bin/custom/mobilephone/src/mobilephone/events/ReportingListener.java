package mobilephone.events;

import de.hybris.platform.servicelayer.model.ModelService;
import mobilephone.enums.Initiator;
import mobilephone.model.EventCreatOrderModel;
import mobilephone.model.PhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component(value = "reportingListener")
public class ReportingListener {

    private final ModelService modelService;

    private final PhoneDetailsService phoneDetailsService;

    public ReportingListener(ModelService modelService, PhoneDetailsService phoneDetailsService) {
        this.modelService = modelService;
        this.phoneDetailsService = phoneDetailsService;
    }

    @EventListener(OrderPhoneCreationEvent.class)
    public void reportOrderPhoneEvent(OrderPhoneCreationEvent event) {
        EventCreatOrderModel eventCreatOrderModel = this.modelService.create(EventCreatOrderModel.class);

        eventCreatOrderModel.setPhone(this.phoneDetailsService.getPhoneForCode(event.getPhoneID()));
        eventCreatOrderModel.setQuantity(event.getQuantity());
        eventCreatOrderModel.setDateCreate(event.getDateCreate());
        eventCreatOrderModel.setInitiator(Initiator.EVENT);
        eventCreatOrderModel.setSendMail(false);
        this.modelService.save(eventCreatOrderModel);
    }
}

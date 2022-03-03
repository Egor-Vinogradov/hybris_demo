package mobilephone.interceptors;

import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import mobilephone.events.OrderPhoneCreationEventHybris;
import mobilephone.model.OrderPhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderPhoneInterceptor implements ValidateInterceptor, PrepareInterceptor {

    @Autowired
    private EventService eventService;

    @Override
    public void onPrepare(Object model, InterceptorContext ctx) throws InterceptorException {
        if (model instanceof OrderPhoneModel) {
            OrderPhoneModel orderPhoneModel = (OrderPhoneModel) model;
            this.eventService.publishEvent(new OrderPhoneCreationEventHybris(orderPhoneModel.getPhone().getCode(),
                    orderPhoneModel.getQuantity(), orderPhoneModel.getDateCreate().toString()));
        }
    }

    @Override
    public void onValidate(Object model, InterceptorContext ctx) throws InterceptorException {
        if (model instanceof OrderPhoneModel) {
            OrderPhoneModel orderPhoneModel = (OrderPhoneModel) model;
            Integer quantity = orderPhoneModel.getQuantity();
            if (quantity <= 0) {
                throw new InterceptorException("Quantity must be positive");
            }
        }
    }
}

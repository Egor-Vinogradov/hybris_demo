package mobilephone.interceptors;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import mobilephone.enums.Initiator;
import mobilephone.events.OrderPhoneCreationEventHybris;
import mobilephone.model.EventCreatOrderModel;
import mobilephone.model.PhoneModel;

public class InterceptorListener extends AbstractEventListener<OrderPhoneCreationEventHybris> {

    private ModelService modelService;
    private ProductService productService;

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void onEvent(OrderPhoneCreationEventHybris event) {
        EventCreatOrderModel eventCreatOrderModel = this.modelService.create(EventCreatOrderModel.class);

        PhoneModel phoneModel = (PhoneModel) this.productService.getProductForCode(event.getPhoneID());

        eventCreatOrderModel.setPhone(phoneModel);
        eventCreatOrderModel.setQuantity(event.getQuantity());
        eventCreatOrderModel.setDateCreate(event.getDateCreate());
        eventCreatOrderModel.setInitiator(Initiator.INTERCEPTOR);

        this.modelService.save(eventCreatOrderModel);
    }
}

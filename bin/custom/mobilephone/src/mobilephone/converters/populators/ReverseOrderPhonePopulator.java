package mobilephone.converters.populators;


import de.hybris.platform.converters.Populator;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import mobilephone.data.OrderPhoneData;
import mobilephone.model.OrderPhoneModel;
import mobilephone.model.PhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "reverseOrderPhonePopulator")
public class ReverseOrderPhonePopulator implements Populator<OrderPhoneData, OrderPhoneModel> {

    private final ProductService productService;
    private final PhoneDetailsService phoneDetailsService;

    public ReverseOrderPhonePopulator(ProductService productService, PhoneDetailsService phoneDetailsService) {
        this.productService = productService;
        this.phoneDetailsService = phoneDetailsService;
    }

    @Override
    public void populate(OrderPhoneData source, OrderPhoneModel target) throws ConversionException {
        target.setPhone(this.phoneDetailsService.getPhoneForCode(source.getPhoneID()));
        Long code = new Random().nextLong();
        target.setCode(code.toString());
        target.setQuantity(source.getQuantity());
    }
}

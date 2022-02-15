package mobilephone.facades.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import mobilephone.data.PhoneData;
import mobilephone.facades.PhoneFacade;
import de.hybris.platform.product.ProductService;

public class DefaultPhoneFacade implements PhoneFacade {

    private ProductService productService;
    private Converter<ProductModel, PhoneData> productConverter;

    @Override
    public PhoneData getPhone(String phoneId) {

        return this.productConverter.convert(this.productService.getProductForCode(phoneId));

    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setProductConverter(Converter<ProductModel, PhoneData> productConverter) {
        this.productConverter = productConverter;
    }
}

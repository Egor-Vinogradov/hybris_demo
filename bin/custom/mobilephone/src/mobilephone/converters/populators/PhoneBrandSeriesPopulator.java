package mobilephone.converters.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import mobilephone.data.PhoneSummaryData;
import mobilephone.model.PhoneModel;

public class PhoneBrandSeriesPopulator implements Populator<PhoneModel, PhoneSummaryData> {

    @Override
    public void populate(PhoneModel source, PhoneSummaryData target) throws ConversionException {

        ProductModel baseProduct = source.getBaseProduct();

        target.setSeries(baseProduct.getSeries().getName());
        target.setBrand(baseProduct.getSeries().getBrand().getName());
        target.setBaseProduct(baseProduct.getCode());
    }
}

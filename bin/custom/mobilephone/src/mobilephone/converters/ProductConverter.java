package mobilephone.converters;

import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.variants.model.VariantProductModel;
import mobilephone.data.PhoneData;
import mobilephone.data.PhoneSummaryData;
import mobilephone.model.PhoneModel;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter implements Converter<ProductModel, PhoneData> {

    @Override
    public PhoneData convert(ProductModel product) throws ConversionException {
        PhoneData target = new PhoneData();
        return convert(product, target);
    }

    @Override
    public PhoneData convert(ProductModel product, PhoneData phoneData) throws ConversionException {
        List<PhoneSummaryData> phoneSummaryDataList = new ArrayList<>();

        if (product.getVariants() != null) {
            for (VariantProductModel variant : product.getVariants()) {
                if (variant instanceof PhoneModel) {
                    PhoneModel phoneModel = (PhoneModel) variant;

                    PhoneSummaryData phone = new PhoneSummaryData();

                    phone.setId(phoneModel.getCode());
                    phone.setName(phoneModel.getNamePhoneModel());
                    phone.setInternalStorage(phoneModel.getInternalStorage().getCode());
                    phone.setOS(phoneModel.getOS().getCode());
                    phoneSummaryDataList.add(phone);
                }
            }
        }

        PhoneData target = new PhoneData();
        target.setId(product.getCode());
        target.setBrand(product.getSeries().getBrand().getName());
        target.setSeries(product.getSeries().getName());
        target.setPhones(phoneSummaryDataList);

        return target;
    }
}

package mobilephone.converters;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import mobilephone.data.OrderPhoneData;
import mobilephone.model.OrderPhoneModel;
import mobilephone.model.PhoneModel;
import org.apache.commons.lang.time.DateFormatUtils;

public class OrderPhoneConverter implements Converter<OrderPhoneModel, OrderPhoneData> {


    @Override
    public OrderPhoneData convert(OrderPhoneModel source) throws ConversionException {
        OrderPhoneData target = new OrderPhoneData();
        return convert(source, target);
    }

    @Override
    public OrderPhoneData convert(OrderPhoneModel source, OrderPhoneData target) throws ConversionException {

        target.setId(source.getCode());
        PhoneModel phoneModel = (PhoneModel) source.getPhone();
        target.setPhoneName(phoneModel.getNamePhoneModel());
        target.setPhoneID(source.getPhone().getCode());
        target.setQuantity(source.getQuantity());
        target.setDateCreate(DateFormatUtils.format(source.getDateCreate(), "dd-MM-yyyy"));

        return target;
    }
}

package mobilephone.converters.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import mobilephone.data.PhoneSummaryData;
import mobilephone.model.PhoneModel;

public class PhoneSummaryPopulator implements Populator<PhoneModel, PhoneSummaryData> {

    @Override
    public void populate(PhoneModel phoneModel, PhoneSummaryData phone) throws ConversionException {
        phone.setId(phoneModel.getCode());
        phone.setName(phoneModel.getNamePhoneModel());
        phone.setInternalStorage(phoneModel.getInternalStorage().getCode());
        phone.setOS(phoneModel.getOS().getCode());
    }
}

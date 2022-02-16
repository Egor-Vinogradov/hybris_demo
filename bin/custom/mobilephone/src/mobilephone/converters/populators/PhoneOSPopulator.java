package mobilephone.converters.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import mobilephone.data.PhoneSummaryData;
import mobilephone.model.PhoneModel;

public class PhoneOSPopulator implements Populator<PhoneModel, PhoneSummaryData> {

    @Override
    public void populate(PhoneModel source, PhoneSummaryData target) throws ConversionException {
        target.setOS(source.getOS().getCode());
    }
}

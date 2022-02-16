package mobilephone.converters.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import mobilephone.data.PhoneSummaryData;
import mobilephone.model.PhoneModel;

public class PhoneISPopulator implements Populator<PhoneModel, PhoneSummaryData> {

    @Override
    public void populate(PhoneModel source, PhoneSummaryData target) throws ConversionException {
        switch (source.getInternalStorage()) {
            case GB64: target.setInternalStorage("64 GB");
                break;
            case GB128: target.setInternalStorage("128 GB");
                break;
            case GB256: target.setInternalStorage("256 GB");
                break;
            case GB512: target.setInternalStorage("512 GB");
                break;
            case GB1024: target.setInternalStorage("1024 GB");
                break;
            default: break;
        }
    }
}

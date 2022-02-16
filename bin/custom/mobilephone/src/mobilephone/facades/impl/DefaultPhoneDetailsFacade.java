package mobilephone.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import mobilephone.data.PhoneSummaryData;
import mobilephone.facades.PhoneDetailsFacade;
import mobilephone.model.PhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.stereotype.Component;

@Component(value = "phoneDetailsFacade")
public class DefaultPhoneDetailsFacade implements PhoneDetailsFacade {

    private final PhoneDetailsService phoneDetailsService;
    private final Converter<PhoneModel, PhoneSummaryData> phoneConverter;

    public DefaultPhoneDetailsFacade(PhoneDetailsService phoneDetailsService,
                                     Converter<PhoneModel, PhoneSummaryData> phoneConverter) {
        this.phoneDetailsService = phoneDetailsService;
        this.phoneConverter = phoneConverter;
    }

    @Override
    public PhoneSummaryData getPhone(String code) {
        return this.phoneConverter.convert(this.phoneDetailsService.getPhoneForCode(code));
    }
}

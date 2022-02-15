package mobilephone.facades.impl;

import mobilephone.data.PhoneSummaryData;
import mobilephone.facades.PhoneDetailsFacade;
import mobilephone.model.PhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.stereotype.Component;

@Component(value = "phoneDetailsFacade")
public class DefaultPhoneDetailsFacade implements PhoneDetailsFacade {

    private final PhoneDetailsService phoneDetailsService;

    public DefaultPhoneDetailsFacade(PhoneDetailsService phoneDetailsService) {
        this.phoneDetailsService = phoneDetailsService;
    }

    @Override
    public PhoneSummaryData getPhone(String code) {
        PhoneSummaryData phone = new PhoneSummaryData();
        PhoneModel phoneModel = this.phoneDetailsService.getPhoneForCode(code);

        // add converter and populator


        phone.setId(phoneModel.getCode());
        phone.setInternalStorage(phoneModel.getInternalStorage().getCode());
        phone.setOS(phoneModel.getOS().getCode());
        phone.setName(phoneModel.getNamePhoneModel());
        return phone;
    }
}

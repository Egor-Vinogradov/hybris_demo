package mobilephone.facades;

import mobilephone.data.PhoneSummaryData;

public interface PhoneDetailsFacade {
    PhoneSummaryData getPhone(String code);
}

package mobilephone.facades;

import mobilephone.data.PhoneData;

public interface PhoneFacade {
    PhoneData getPhone(final String phoneId);
}

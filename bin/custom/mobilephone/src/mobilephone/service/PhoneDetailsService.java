package mobilephone.service;

import mobilephone.model.PhoneModel;

public interface PhoneDetailsService {
    PhoneModel getPhoneForCode(String code);
}

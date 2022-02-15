package mobilephone.service.impl;

import mobilephone.daos.PhoneDAO;
import mobilephone.model.PhoneModel;
import mobilephone.service.PhoneDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "phoneDetailsService")
public class DefaultPhoneDetailsService implements PhoneDetailsService {

    private final PhoneDAO phoneDAO;

    public DefaultPhoneDetailsService(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public PhoneModel getPhoneForCode(String code) {
        return this.phoneDAO.findPhoneByCode(code).get(0);
    }
}

package mobilephone.daos;

import mobilephone.model.PhoneModel;

import java.util.List;

public interface PhoneDAO {

    List<PhoneModel> findPhones();
    List<PhoneModel> findPhoneByCode(String code);
}

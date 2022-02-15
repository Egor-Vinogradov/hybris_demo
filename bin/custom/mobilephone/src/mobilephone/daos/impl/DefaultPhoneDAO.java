package mobilephone.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import mobilephone.daos.PhoneDAO;
import mobilephone.model.PhoneModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "phoneDAO")
public class DefaultPhoneDAO implements PhoneDAO {

    private final FlexibleSearchService flexibleSearchService;

    public DefaultPhoneDAO(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<PhoneModel> findPhones() {
        return null;
    }

    @Override
    public List<PhoneModel> findPhoneByCode(String code) {
        String queryString = //
                "SELECT {p:" + PhoneModel.PK + "}" //
                        + "FROM {" + PhoneModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + PhoneModel.CODE + "}=?code ";
        FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.<PhoneModel> search(query).getResult();
    }
}

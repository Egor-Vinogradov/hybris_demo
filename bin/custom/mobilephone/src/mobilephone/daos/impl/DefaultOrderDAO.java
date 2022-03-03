package mobilephone.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import mobilephone.daos.OrderDAO;
import mobilephone.model.OrderPhoneModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "orderPhoneDAO")
public class DefaultOrderDAO implements OrderDAO {

    private final FlexibleSearchService flexibleSearchService;

    public DefaultOrderDAO(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<OrderPhoneModel> findOrdersPhone() {
        String queryString = //
                "SELECT {p:" + OrderPhoneModel.PK + "} "//
                        + "FROM {" + OrderPhoneModel._TYPECODE + " AS p} ";
        FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return this.flexibleSearchService.<OrderPhoneModel> search(query).getResult();
    }

    @Override
    public List<OrderPhoneModel> findOrdersPhoneByCode(String code) {
        String queryString = //
                "SELECT {p:" + OrderPhoneModel.PK + "}" //
                        + "FROM {" + OrderPhoneModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + OrderPhoneModel.CODE + "}=?code ";
        FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return this.flexibleSearchService.<OrderPhoneModel> search(query).getResult();
    }
}

package mobilephone.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import mobilephone.daos.EventCreatOrderDAO;
import mobilephone.model.EventCreatOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component(value = "eventCreatOrderDAO")
public class DefaultEventCreatOrderDAO implements EventCreatOrderDAO {

//    private final FlexibleSearchService flexibleSearchService;

    private static final String SQL_DATE_FORMAT = "yyyy-MM-dd";

//    public DefaultEventCreatOrderDAO(FlexibleSearchService flexibleSearchService) {
//        this.flexibleSearchService = flexibleSearchService;
//    }

    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<EventCreatOrderModel> findEventByData(Date date) {

        if (date == null) {
            return Collections.emptyList();
        }

        String theDay = new SimpleDateFormat(SQL_DATE_FORMAT).format(date);
        String theNextDay = new SimpleDateFormat(SQL_DATE_FORMAT).format(oneDayAfter(date));
        String queryString = //
                "SELECT {p:" + EventCreatOrderModel.PK + "} "//
                        + "FROM {" + EventCreatOrderModel._TYPECODE + " AS p} " //
                        + "WHERE {dateCreate} >= DATE \'" + theDay + "\' "//
                        + "AND {dateCreate} <= DATE \'" + theNextDay + "\'";
        FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return this.flexibleSearchService.<EventCreatOrderModel> search(query).getResult();
    }

    private Date oneDayAfter(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
}

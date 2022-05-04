package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.listener;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.service.Statistics;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class UsersLister implements HttpSessionAttributeListener {
    private static final Statistics statistics = Statistics.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        Object user = event.getSession().getAttribute("user");
        if (user != null) {
            statistics.incrementUsers();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        statistics.decrementUsers();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}

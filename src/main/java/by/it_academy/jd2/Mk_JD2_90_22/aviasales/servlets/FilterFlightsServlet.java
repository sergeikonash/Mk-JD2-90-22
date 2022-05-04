package by.it_academy.jd2.Mk_JD2_90_22.aviasales.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilterFlightsServlet", urlPatterns = "/filterFlights")
public class FilterFlightsServlet extends HttpServlet {

    private static final String REQUEST_DATE_OF_DEPARTURE = null;
    private static final String REQUEST_AIRPORT_OF_DEPARTURE = null;
    private static final String REQUEST_DATE_OF_ARRIVAL = null;
    private static final String REQUEST_AIRPORT_OF_ARRIVAL = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FlightsService flightsService = new FlightsService();

        flightsService.setDateOfDeparture(req.getParameter(REQUEST_DATE_OF_DEPARTURE));
        flightsService.setAirportOfDeparture(req.getParameter(REQUEST_AIRPORT_OF_DEPARTURE));
        flightsService.setDateOfArrival(req.getParameter(REQUEST_DATE_OF_ARRIVAL));
        flightsService.setAirportOfArrival(req.getParameter(REQUEST_AIRPORT_OF_ARRIVAL));

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/flightsWithFilters");
    }
}

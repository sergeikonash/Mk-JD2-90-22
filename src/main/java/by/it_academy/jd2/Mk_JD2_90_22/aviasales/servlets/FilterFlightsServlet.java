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

    private static final String REQUEST_DATE_OF_DEPARTURE = "dateOfDeparture";
    private static final String REQUEST_AIRPORT_OF_DEPARTURE = "airportOfDeparture";
    private static final String REQUEST_DATE_OF_ARRIVAL = "dateOfArrival";
    private static final String REQUEST_AIRPORT_OF_ARRIVAL = "airportOfArrival";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dateOfDeparture = req.getParameter(REQUEST_DATE_OF_DEPARTURE);
        String airportOfDeparture = req.getParameter(REQUEST_AIRPORT_OF_DEPARTURE);
        String dateOfArrival = req.getParameter(REQUEST_DATE_OF_ARRIVAL);
        String airportOfArrival = req.getParameter(REQUEST_AIRPORT_OF_ARRIVAL);

        FlightsService.setDateOfDeparture(dateOfDeparture);
        FlightsService.setAirportOfDeparture(airportOfDeparture);
        FlightsService.setDateOfArrival(dateOfArrival);
        FlightsService.setAirportOfArrival(airportOfArrival);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/flightsWithFilters");
    }
}

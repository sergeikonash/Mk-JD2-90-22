package by.it_academy.jd2.Mk_JD2_90_22.aviasales.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Flight;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FilterWithFlightsServlet", urlPatterns = "/flightsWithFilters")
public class FlightsWithFiltersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlightsService flightsService = new FlightsService();
        List<Flight> flights = flightsService.filteredList();
        List<String> airports = flightsService.getAirports();
        req.setAttribute("flights", flights);
        req.setAttribute("airports", airports);

        req.getRequestDispatcher("jsp/aviasales/FlightsWithFilters.jsp").forward(req, resp);
    }
}

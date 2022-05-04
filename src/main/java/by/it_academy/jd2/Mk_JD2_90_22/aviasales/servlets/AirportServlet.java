package by.it_academy.jd2.Mk_JD2_90_22.aviasales.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Airport;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.AirportPoolDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirportServlet", urlPatterns = "/airports")
public class AirportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAirportDao airportDao = new AirportPoolDao();
        List<Airport> airports = airportDao.getAll();
        req.setAttribute("airports", airports);

        req.getRequestDispatcher("jsp/aviasales/AirportTable.jsp").forward(req, resp);
    }
}

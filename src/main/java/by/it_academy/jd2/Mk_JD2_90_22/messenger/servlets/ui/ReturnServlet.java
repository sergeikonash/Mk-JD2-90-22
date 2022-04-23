package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReturnServlet", urlPatterns = "/ui/return")
public class ReturnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/Mistake.jsp").forward(req, resp);
    }
}

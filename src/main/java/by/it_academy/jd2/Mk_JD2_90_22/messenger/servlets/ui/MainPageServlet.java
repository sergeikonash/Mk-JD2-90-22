package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.ui;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", urlPatterns = "/ui")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        req.setAttribute("user", user);
        req.getRequestDispatcher("/jsp/MainPage.jsp").forward(req, resp);
    }
}
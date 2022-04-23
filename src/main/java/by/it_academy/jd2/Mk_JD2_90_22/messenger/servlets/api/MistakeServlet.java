package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MistakeServlet", urlPatterns = "/api/mistake")
public class MistakeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/ui/signIn");

    }
}

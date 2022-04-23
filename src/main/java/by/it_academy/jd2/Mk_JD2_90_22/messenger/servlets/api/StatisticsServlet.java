package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.api;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.Statistics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<p>" + "Число пользователей - " + Statistics.getInstance().getCountUsers() + "<p>");
        writer.write("<p>" + "Число сообщений - " + Statistics.getInstance().getCountMessages() + "<p>");
    }

}

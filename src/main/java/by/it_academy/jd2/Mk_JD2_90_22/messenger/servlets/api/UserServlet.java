package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.api;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;
import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private static final String REQUEST_LOGIN_NAME = "login";
    private static final String REQUEST_PASSWORD_NAME = "password";
    private static final String REQUEST_NAME_NAME = "name";
    private static final String REQUEST_DATE_NAME = "dateOfBirth";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(REQUEST_LOGIN_NAME);
        String password = req.getParameter(REQUEST_PASSWORD_NAME);
        String name = req.getParameter(REQUEST_NAME_NAME);
        String dateOfBirth = req.getParameter(REQUEST_DATE_NAME);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setDateOfBirth(LocalDate.parse(dateOfBirth, formatter));
        UserService.add(user);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/ui/signIn");
    }
}

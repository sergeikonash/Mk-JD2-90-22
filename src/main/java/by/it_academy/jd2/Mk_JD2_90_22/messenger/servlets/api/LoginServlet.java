package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.api;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;
import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.SessionStorage;
import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private static final String REQUEST_LOGIN_NAME = "login";
    private static final String REQUEST_PASSWORD_NAME = "password";

    private String login;
    private String password;
    private User user;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        login = req.getParameter(REQUEST_LOGIN_NAME);
        password = req.getParameter(REQUEST_PASSWORD_NAME);

        String contextPath = req.getContextPath();

        user = UserService.isExist(login);
        if (user != null && password.equals(user.getPassword())) {
            resp.sendRedirect(contextPath + "/ui/user/message");
        } else {
            resp.sendRedirect(contextPath + "/ui/return");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionStorage sessionStorage = new SessionStorage();
        sessionStorage.addSession(req, resp, user);
    }
}


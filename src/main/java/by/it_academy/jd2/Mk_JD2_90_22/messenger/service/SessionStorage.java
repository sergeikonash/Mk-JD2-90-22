package by.it_academy.jd2.Mk_JD2_90_22.messenger.service;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionStorage{

    private static final SessionStorage instance = new SessionStorage();
    private Map<String, HttpSession> sessions = new HashMap<>();

    public void addSession(HttpServletRequest req, HttpServletResponse resp, User user) {
        HttpSession session = req.getSession();
        session.setAttribute(user.getLogin(), user);
        sessions.put(user.getLogin(), session);
    }

    public HttpSession getSession(User user) {
        return sessions.get(user.getLogin());
    }

    public static SessionStorage getInstance() {
        return instance;
    }
}

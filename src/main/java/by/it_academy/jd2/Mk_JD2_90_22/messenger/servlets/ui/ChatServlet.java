package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.ui;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.Message;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;


@WebServlet(name = "ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<LocalDateTime, Message> messages = MessageService.getMessages();

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/jsp/Chats.jsp").forward(req, resp);

    }
}
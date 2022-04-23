package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.api;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.Message;
import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;
import by.it_academy.jd2.Mk_JD2_90_22.messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class SentMessageServlet extends HttpServlet {

    private static final String REQUEST_RECIPIENT_NAME = "recipient";
    private static final String REQUEST_TEXT_NAME = "text";

    Message message = new Message();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        Map<LocalDateTime, Message> messages = MessageService.getMessages();

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/jsp/Chats.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String recipient = req.getParameter(REQUEST_RECIPIENT_NAME);
        String text = req.getParameter(REQUEST_TEXT_NAME);

        User user = (User)(req.getSession().getAttribute("user"));
        message.setSender(user.getLogin());
        message.setRecipient(recipient);
        message.setTextOfMassage(text);
        MessageService.addMessage(message);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/ui/user/chats");
    }

}

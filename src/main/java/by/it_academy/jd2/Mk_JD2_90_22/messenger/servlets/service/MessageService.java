package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.service;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.Message;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MessageService {
    private static Map<LocalDateTime, Message> messages = new HashMap<>();

    public static Map<LocalDateTime, Message> getMessages() {
        return messages;
    }

    public static void addMessage(Message message) {
        messages.put(message.getDateAndTimeOfSent(), message);
    }
}

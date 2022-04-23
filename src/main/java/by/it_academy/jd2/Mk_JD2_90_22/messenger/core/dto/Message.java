package by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto;

import java.time.LocalDateTime;

public class Message {
    LocalDateTime dateAndTimeOfSent;
    String sender;
    String recipient;
    String textOfMassage;

    public Message() {
        this.dateAndTimeOfSent = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTextOfMassage() {
        return textOfMassage;
    }

    public void setTextOfMassage(String textOfMassage) {
        this.textOfMassage = textOfMassage;
    }

    public LocalDateTime getDateAndTimeOfSent() {
        return dateAndTimeOfSent;
    }

    @Override
    public String toString() {
        return dateAndTimeOfSent +
                ", отправитель - " + sender +
                ", получатель - " + recipient +
                ", Massage:\n" + textOfMassage + "\n";
    }
}

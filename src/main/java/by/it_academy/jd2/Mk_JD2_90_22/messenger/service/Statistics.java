package by.it_academy.jd2.Mk_JD2_90_22.messenger.service;

public class Statistics {
    private static final Statistics instance = new Statistics();

    private long countUsers;
    private long countMessages;

    public long getCountUsers() {
        return countUsers;
    }

    public long getCountMessages() {
        return countMessages;
    }

    public void incrementUsers() {
        countUsers++;
    }

    public void decrementUsers() {
        countUsers--;
    }

    public void incrementMessages() {
        countMessages++;
    }

    public static Statistics getInstance() {
        return instance;
    }
}

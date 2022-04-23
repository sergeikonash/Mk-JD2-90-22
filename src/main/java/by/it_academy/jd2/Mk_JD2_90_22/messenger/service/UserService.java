package by.it_academy.jd2.Mk_JD2_90_22.messenger.service;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers(){
        return users;
    }

    public static void add(User user){
        users.add(user);
    }

    public static User isExist(String login) {
        for (User user:users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}

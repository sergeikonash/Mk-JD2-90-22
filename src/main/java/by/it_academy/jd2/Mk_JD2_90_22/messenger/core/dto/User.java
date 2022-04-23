package by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto;

import java.time.LocalDate;

public class User {
    private static byte count = 0;
    private String login;
    private String password;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfRegistration;
    private String role;

    public User() {
        this.dateOfRegistration = LocalDate.now();
        adminOrUser();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    private void adminOrUser() {
        if (count == 0) {
            this.role = "Admin";
            count++;
        } else {
            this.role = "User";
        }
    }
}

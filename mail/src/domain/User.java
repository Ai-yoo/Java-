package domain;

import java.util.Date;

public class User {
//    private int id;
    private String name;
    private String password;
    private String email;
    private String randomcode;
    private Object date;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public User(String name, String password, String email, String randomcode, Date date) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.randomcode = randomcode;
        this.date = date;
    }

    public User() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", randomcode='" + randomcode + '\'' +
                ", date=" + date +
                '}';
    }
}

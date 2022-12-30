package model;

import java.util.Objects;

public class Message {
    private String subject;
    private String message;


    public Message(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + subject + '\'' +
                ", password='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getSubject(), user.getUsername()) &&
                Objects.equals(getMessage(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getMessage());
    }
}

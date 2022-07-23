package com.bezkoder.spring.security.postgresql.email;

public interface EmailSender {

    void send(String to, String email);
}

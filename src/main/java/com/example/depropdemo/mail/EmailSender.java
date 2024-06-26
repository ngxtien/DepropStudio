package com.example.depropdemo.mail;

public interface EmailSender {
    public void send(String message, String targetEmail) throws Exception;

}

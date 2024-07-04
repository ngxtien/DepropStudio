package com.example.depropdemo.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


@Service
public class GmailSender implements EmailSender{

    @Autowired
    private JavaMailSender gmailSender;

    public void send(String template ,String email, int orderId) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = gmailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("deprop.contact@gmail.com", "DepropStu");
        helper.setTo(email);
        helper.setSubject("Xác nhận đơn hàng#" + orderId);
        helper.setText(template, true);
        gmailSender.send(message);
    }
}

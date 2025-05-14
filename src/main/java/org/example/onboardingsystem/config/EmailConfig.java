package org.example.onboardingsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component

public class EmailConfig {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toEmail,String subject,String Body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ujjwal1281.be21@chitkarauniversity.edu.in");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(Body);
        javaMailSender.send(message);
        System.out.println("Mail sent successfully");
    }

}

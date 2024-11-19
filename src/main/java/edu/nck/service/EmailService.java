package edu.nck.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;


    EmailService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    private String generateVerificationCode(){
        Random randomCode = new Random();
        int verificationCode = 1000+randomCode.nextInt(9000);
        return String.valueOf(verificationCode);
    }

    public String sendVerificationEmail(String email){

        String verificationCode = generateVerificationCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("linklife895@gmail.com");
        message.setTo(email);
        message.setSubject("Email Verification Code");
        message.setText("Your verification code is: "+verificationCode);

        javaMailSender.send(message);

        return verificationCode;
    }
}

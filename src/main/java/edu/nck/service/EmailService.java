package edu.nck.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

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

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }

        return verificationCode;
    }

    public boolean sendDonorInfoToHospital(String donorEmail, String donorFirstName, String donorLastName,
                                           String donorPhone, String donorBloodType, String patientFirstName,
                                           String patientLastName, String patientAge, String patientOrgan,
                                           String patientBloodType) {

        String emailBody = buildEmailBody(donorFirstName, donorLastName, donorPhone, donorBloodType,
                patientFirstName, patientLastName, patientAge, patientOrgan,
                patientBloodType);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(donorEmail); // Send from donor's email address
        message.setTo("linklife895@gmail.com"); // Send to hospital's email address
        message.setSubject("Potential Donor Information for " + patientFirstName + " " + patientLastName);
        message.setText(emailBody); // Email content

        try {
            javaMailSender.send(message);
            return true; // Success
        } catch (MailException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private String buildEmailBody(String donorFirstName, String donorLastName, String donorPhone,
                                  String donorBloodType, String patientFirstName, String patientLastName,
                                  String patientAge, String patientOrgan, String patientBloodType) {
        return "Donor Details:\n" +
                "Name: " + donorFirstName + " " + donorLastName + "\n" +
                "Phone: " + donorPhone + "\n" +
                "Blood Type: " + donorBloodType + "\n\n" +
                "Patient Details:\n" +
                "Name: " + patientFirstName + " " + patientLastName + "\n" +
                "Age: " + patientAge + "\n" +
                "Organ Needed: " + patientOrgan + "\n" +
                "Blood Type: " + patientBloodType + "\n\n" +
                "Donor's Preference: [Specify any additional preference or note here]";
    }

}

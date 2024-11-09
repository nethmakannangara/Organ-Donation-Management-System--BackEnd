package edu.nck.controller;

import edu.nck.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("verification")
@CrossOrigin
public class VerificationController {

    private final EmailService emailService;

    @Autowired
    public VerificationController(EmailService emailService){
        this.emailService = emailService;
    }

    @GetMapping("/send-verification")
    public String sendCode(@RequestParam String email){
        System.out.println(email);
//        emailService.sendVerificationEmail(email);
        return "1234";
    }

}

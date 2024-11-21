package edu.nck.controller;

import edu.nck.model.LoginInfo;
import edu.nck.service.EmailService;
import edu.nck.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final EmailService emailService;
    private final LoginService loginService;

    @GetMapping("/{email}")
    public String sendCode(@PathVariable String email){
        return emailService.sendVerificationEmail(email);
    }

    @PostMapping()
    public boolean saveInfo(@RequestBody LoginInfo loginInfo){
        return loginService.register(loginInfo);
    }
}

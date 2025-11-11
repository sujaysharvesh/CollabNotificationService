package com.example.EmailService.Controller;


import com.example.EmailService.DTOs.User;
import com.example.EmailService.Service.EmailService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/welcome")
    public ResponseEntity<String> sendWelcomeMail(@RequestBody User user) {
        try {
            emailService.sendWelcomeMail(user);
            return ResponseEntity.ok("mail Send");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" + e.getMessage());
        }

    }

}

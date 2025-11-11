package com.example.EmailService.Service;

import com.example.EmailService.DTOs.User;
import org.springframework.stereotype.Service;


public interface EmailService {

    void sendWelcomeMail(User user);
}

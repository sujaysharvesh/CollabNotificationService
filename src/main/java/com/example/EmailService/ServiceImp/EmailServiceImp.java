package com.example.EmailService.ServiceImp;

import com.example.EmailService.DTOs.User;
import com.example.EmailService.Service.EmailService;
import com.example.EmailService.Template.EmailTemplate;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService {


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}") private String adminMail;

    @Override
    public void sendWelcomeMail(User user) {
        try {

            String template = EmailTemplate.getWelcomeMailTemplate(user.getUserName());

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper  helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(adminMail);
            helper.setTo(user.getUserMail());
            helper.setSubject("Welcome Message");
            helper.setText(template, true);
            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException("Failed to send HTML email: " + e.getMessage());
        }
    }

}

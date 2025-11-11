package com.example.EmailService.Email;


import com.example.EmailService.Service.EmailService;
import com.example.EmailService.Template.EmailTemplate;
import com.example.grpc.EmailResponse;
import com.example.grpc.EmailServiceGrpc;
import com.example.grpc.User;
import io.grpc.stub.StreamObserver;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.grpc.server.service.GrpcService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@GrpcService
public class EmailGrpcService extends EmailServiceGrpc.EmailServiceImplBase {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}") private String adminMail;

    @Override
    public void sendWelcomeMail(User user, StreamObserver<EmailResponse> responseObserver) {
        try {

            String template = EmailTemplate.getWelcomeMailTemplate(user.getUserName());

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(adminMail);
            helper.setTo(user.getUserMail());
            helper.setSubject("Welcome Message");
            helper.setText(template, true);
            mailSender.send(message);

            EmailResponse response = EmailResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Registration email sent successfully to " + user.getUserMail()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {

            EmailResponse response = EmailResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to send registration email")
                    .setErrorDetails(e.getMessage())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
    }
}

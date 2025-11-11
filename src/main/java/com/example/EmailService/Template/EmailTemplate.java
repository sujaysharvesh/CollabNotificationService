package com.example.EmailService.Template;


import org.springframework.stereotype.Service;

@Service
public class EmailTemplate {

    public static String getWelcomeMailTemplate(String userName) {
        return "<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <title>Welcome Email</title>" +
                "</head>" +
                "<body style='margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f4f4f4;'>" +
                "    <table width='100%' cellpadding='0' cellspacing='0' border='0'>" +
                "        <tr>" +
                "            <td align='center' style='padding: 40px 0;'>" +
                "                <table width='600' cellpadding='0' cellspacing='0' border='0' style='background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);'>" +
                "                    <!-- Header -->" +
                "                    <tr>" +
                "                        <td style='background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 40px 30px; text-align: center; border-radius: 8px 8px 0 0;'>" +
                "                            <h1 style='color: #ffffff; margin: 0; font-size: 28px;'>Welcome to Our Platform!</h1>" +
                "                        </td>" +
                "                    </tr>" +
                "                    <!-- Body -->" +
                "                    <tr>" +
                "                        <td style='padding: 40px 30px;'>" +
                "                            <h2 style='color: #333333; margin-top: 0;'>Hi " + userName + ",</h2>" +
                "                            <p style='color: #666666; font-size: 16px; line-height: 1.6;'>" +
                "                                Thank you for joining us! We're excited to have you on board." +
                "                            </p>" +
                "                            <p style='color: #666666; font-size: 16px; line-height: 1.6;'>" +
                "                                To get started, please verify your email address by clicking the button below:" +
                "                            </p>" +
                "                            <table cellpadding='0' cellspacing='0' border='0' style='margin: 30px 0;'>" +
                "                                <tr>" +
                "                                    <td align='center'>" +
                "                                        <a href='#' style='background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: #ffffff; padding: 14px 40px; text-decoration: none; border-radius: 5px; font-weight: bold; display: inline-block;'>Verify Email</a>" +
                "                                    </td>" +
                "                                </tr>" +
                "                            </table>" +
                "                            <p style='color: #666666; font-size: 16px; line-height: 1.6;'>" +
                "                                If you have any questions, feel free to reach out to our support team." +
                "                            </p>" +
                "                        </td>" +
                "                    </tr>" +
                "                    <!-- Footer -->" +
                "                    <tr>" +
                "                        <td style='background-color: #f8f9fa; padding: 30px; text-align: center; border-radius: 0 0 8px 8px;'>" +
                "                            <p style='color: #999999; font-size: 14px; margin: 0;'>" +
                "                                © 2025 Your Company. All rights reserved." +
                "                            </p>" +
                "                            <p style='color: #999999; font-size: 14px; margin: 10px 0 0 0;'>" +
                "                                <a href='#' style='color: #667eea; text-decoration: none;'>Unsubscribe</a> | " +
                "                                <a href='#' style='color: #667eea; text-decoration: none;'>Privacy Policy</a>" +
                "                            </p>" +
                "                        </td>" +
                "                    </tr>" +
                "                </table>" +
                "            </td>" +
                "        </tr>" +
                "    </table>" +
                "</body>" +
                "</html>";
    }

}

package org.example.clean_code_test.systems.dependency_injection.service;

public class SmtpEmailService implements EmailService{
    @Override
    public void sendEmail(String recipient, String message) {
        System.out.println("Sending email to "+ recipient + ": "+ message);
    }
}

package org.example.clean_code_test.systems.dependency_injection.service;

public class UserService {
    private final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser(String username){
        System.out.println("Registering user : "+username);
        emailService.sendEmail(username+"@gmail.com","Welcome!");
    }
}

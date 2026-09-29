package org.example.clean_code_test.systems.dependency_injection;

import org.example.clean_code_test.systems.dependency_injection.service.EmailService;
import org.example.clean_code_test.systems.dependency_injection.service.SmtpEmailService;
import org.example.clean_code_test.systems.dependency_injection.service.UserService;

public class DIContainerSetup {
    public static void main(String[] args) {
        // In a real Spring application, this wiring is handled automatically
        // via annotations (@Autowired, @Service, etc.) or configuration classes.
        EmailService emailService = new SmtpEmailService();
        UserService userService  = new UserService(emailService);

        userService.registerUser("Arkar Hein");
    }
}

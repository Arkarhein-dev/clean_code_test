package org.example.clean_code_test.error_handling.problem_with_checked_ex;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
}

// Layer 1: The Low-Level Trigger
 class DataRepository {
    // Switching to a file system introduces a checked exception
    public void save(String data) throws IOException {
        FileWriter writer = new FileWriter("db.txt");
        writer.write(data);
        writer.close();
    }
}

// Layer 2: The First Ripple Ripple
 class BusinessService {
    private DataRepository repo = new DataRepository();

    // BROKEN: This no longer compiles unless we add 'throws IOException'
    public void processAndSave(String data) throws IOException {
        String processed = data.toUpperCase();
        repo.save(processed);
    }
}

// Layer 3: The Top-Level Crash
 class WebController {
    private BusinessService service = new BusinessService();

    // BROKEN: The ripple reaches the presentation layer.
    // A web controller now has to import and declare an I/O exception!
    public void handleUserRequest(String input) throws IOException {
        service.processAndSave(input);
    }
}










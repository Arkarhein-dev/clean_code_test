package org.example.clean_code_test.systems.separation_of_main;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("[LOG]: "+ message);
    }
}

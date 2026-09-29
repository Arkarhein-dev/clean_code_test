package org.example.clean_code_test.functions.arguments.argument_list;

public class LoggerUtil {
    public void logEvents(String prefix, String... messages){
        for (String message: messages){
            System.out.println(prefix+": "+ message);
        }
    }

    public static void main(String[] args) {
        LoggerUtil loggerUtil = new LoggerUtil();
        loggerUtil.logEvents("INFO", "Application started successfully.");
        loggerUtil.logEvents("DEBUG","Connecting to databases", "logging users details", " closed database connection.");
    }
}

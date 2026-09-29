package org.example.clean_code_test.error_handling.define_ex_caller_need.exception;

public class DeviceResponseException extends RuntimeException{
    public DeviceResponseException(String message) {
        super(message);
    }
}

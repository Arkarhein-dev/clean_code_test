package org.example.clean_code_test.error_handling.define_ex_caller_need.exception;

public class PortDeviceFailure extends RuntimeException{
    public PortDeviceFailure(Throwable cause){
        super("Port device failure occurred",cause);
    }
}

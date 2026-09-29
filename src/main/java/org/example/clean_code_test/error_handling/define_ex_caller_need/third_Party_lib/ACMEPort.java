package org.example.clean_code_test.error_handling.define_ex_caller_need.third_Party_lib;

import org.example.clean_code_test.error_handling.define_ex_caller_need.exception.PortDeviceFailure;

// Assume that this is third party library
public class ACMEPort {
    private int portNumber;

    public ACMEPort(int portNumber) {
        this.portNumber = portNumber;
    }

    public void openPort(){
        // implementation here
        System.out.println("Open port number bla bla...");
    }
}
